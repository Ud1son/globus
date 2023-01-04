package ru.udisondev.globus.auction.bid.service;

import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.auction.bid.config.BidProperties;
import ru.udisondev.globus.auction.bid.publisher.BidEventPublisher;
import ru.udisondev.globus.auction.bid.service.model.BidDataProvider;
import ru.udisondev.globus.auction.bid.service.model.BidInfo;
import ru.udisondev.globus.exception.BidNotFoundException;
import ru.udisondev.globus.persistence.bid.Bid;
import ru.udisondev.globus.persistence.bid.BidRepository;
import ru.udisondev.globus.persistence.enums.BidState;

import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.udisondev.globus.persistence.enums.BidState.*;

@Service
@CacheConfig(
        cacheNames = BidProperties.CACHE_NAME,
        cacheManager = BidProperties.CACHE_MANAGER_NAME
)
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final BidMapper mapper;
    private final BidEventPublisher eventPublisher;

    public BidServiceImpl(BidRepository bidRepository, BidMapper mapper, BidEventPublisher eventPublisher) {
        this.bidRepository = bidRepository;
        this.mapper = mapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    @CachePut(key = "#{result.id}")
    public BidInfo create(BidDataProvider bidDataProvider) {
        var bid = bidRepository.saveAndFlush(mapper.toEntry(bidDataProvider));
        eventPublisher.publish(mapper.toEvent(bid));
        return mapper.toDto(bid);
    }

    @Override
    @Transactional
    public void approve(UUID id) {
        updateStateWithEventPublishing(id, APPROVED, bid -> bid.getState() == REQUESTED);
    }

    @Override
    @Transactional
    public void confirm(UUID id) {
        updateStateWithEventPublishing(id, CONFIRMED, bid -> bid.getState() == REQUESTED);
    }

    @Override
    public void reject(UUID bidId) {
        updateStateWithEventPublishing(bidId, REJECTED, bid -> bid.getState() == REQUESTED);
    }

    @Override
    public void cancel(UUID bidId) {
        updateStateWithEventPublishing(bidId, CANCELLED, bid -> bid.getState() == REQUESTED);
    }

    @Override
    @Transactional
    public void closeAllByLotId(UUID id) {
        var closed = bidRepository.findAllByLotId(id).stream()
                .parallel()
                .peek(b -> b.setState(BidState.CLOSED))
                .collect(Collectors.toList());
        var updatedBids = bidRepository.saveAll(closed);

        updatedBids.stream()
                .map(mapper::toEvent)
                .forEach(eventPublisher::publish);
    }

    @Override
    @Transactional
    public void closeAllByLotIdExcludeConfirmed(UUID id, UUID confirmedBidId) {
        var closed = bidRepository.findAllByLotIdExcludeConfirmedBid(id, confirmedBidId).stream()
                .peek(b -> b.setState(BidState.CLOSED))
                .collect(Collectors.toList());

        var updatedBids = bidRepository.saveAll(closed);

        updatedBids.stream()
                .map(mapper::toEvent)
                .forEach(eventPublisher::publish);
    }

    @Transactional
    private void updateStateWithEventPublishing(UUID bidId, BidState bidState, Predicate<Bid> possibleResolver) {
        var bid = bidRepository.findByIdForUpdate(bidId).orElseThrow(() -> BidNotFoundException.byId(bidId));
        if (!possibleResolver.test(bid)) {
            return;
        }

        bid.setState(bidState);
        var updatedBid = bidRepository.save(bid);
        eventPublisher.publish(mapper.toEvent(updatedBid));
    }
}
