package ru.udisondev.globus.auction.lot.service;

import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.auction.lot.config.LotProperties;
import ru.udisondev.globus.auction.lot.event.LotEventPublisher;
import ru.udisondev.globus.exception.LotNotFoundException;
import ru.udisondev.globus.persistence.enums.LotState;
import ru.udisondev.globus.persistence.lot.LotRepository;

import java.util.UUID;

import static ru.udisondev.globus.persistence.enums.LotState.COMPLETED;
import static ru.udisondev.globus.persistence.enums.LotState.OPENED;

@Service
@CacheConfig(
        cacheNames = LotProperties.CACHE_NAME,
        cacheManager = LotProperties.CACHE_MANAGER_NAME
)
public class LotServiceImpl implements LotService {

    private final LotRepository lotRepository;
    private final LotMapper mapper;
    private final LotEventPublisher lotEventPublisher;

    public LotServiceImpl(LotRepository lotRepository, LotMapper mapper, LotEventPublisher lotEventPublisher) {
        this.lotRepository = lotRepository;
        this.mapper = mapper;
        this.lotEventPublisher = lotEventPublisher;
    }

    @Override
    @CachePut(key = "#{result.id}")
    public LotInfo create(LotDataProvider lotDataProvider) {
        var lot = lotRepository.save(mapper.toEntity(lotDataProvider));
        lotEventPublisher.publish(mapper.toEvent(lot));
        return mapper.toDto(lot);
    }

    @Override
    @Transactional
    public void complete(UUID lotId, UUID confirmedBidId) {
        var lot = lotRepository.findByIdForUpdate(lotId).orElseThrow(() -> LotNotFoundException.byId(lotId));
        if (lot.getState() != OPENED) {
            return;
        }
        lot.setState(COMPLETED);
        lot.setConfirmedBidId(confirmedBidId);
        var updatedLot = lotRepository.save(lot);

        lotEventPublisher.publish(mapper.toEvent(updatedLot));
    }

    @Override
    @Transactional
    public void cancel(String claimId) {
        var lot = lotRepository.findByClaimIdForUpdate(claimId).orElseThrow(() -> LotNotFoundException.byClaimId(claimId));
        if (lot.getState() != OPENED) {
            return;
        }
        lot.setState(LotState.CANCELLED);
        var updatedLot = lotRepository.save(lot);

        lotEventPublisher.publish(mapper.toEvent(updatedLot));
    }

    @Override
    @Cacheable
    public LotInfo findLotById(UUID lotId) {
        return mapper.toDto(lotRepository.findById(lotId).orElseThrow(() -> LotNotFoundException.byId(lotId)));
    }
}
