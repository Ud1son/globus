package ru.udisondev.globus.auction.bid.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.auction.bid.service.BidService;

import java.util.UUID;

@Service
@ConditionalOnMissingBean(BidClient.class)
public class ApplicationBidClientImpl implements BidClient {

    private final BidService bidService;
    private final BidApiMapper mapper;

    public ApplicationBidClientImpl(BidService bidService, BidApiMapper mapper) {
        this.bidService = bidService;
        this.mapper = mapper;
    }

    @Override
    public BidDto create(CreateBidRequest request) {
        return mapper.toResponse(bidService.create(request));
    }

    @Override
    public void approve(UUID bidId) {
        bidService.approve(bidId);
    }

    @Override
    public void confirm(UUID bidId) {
        bidService.confirm(bidId);
    }

    @Override
    public void reject(UUID bidId) {
        bidService.reject(bidId);
    }

    @Override
    public void cancel(UUID bidId) {
        bidService.cancel(bidId);
    }
}
