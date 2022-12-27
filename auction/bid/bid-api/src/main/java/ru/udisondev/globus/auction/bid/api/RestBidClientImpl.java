package ru.udisondev.globus.auction.bid.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;
import ru.udisondev.globus.auction.bid.service.BidService;

import java.util.UUID;

@RestController
@RequestMapping("/bid")
@ConditionalOnProperty(prefix = "app", name = "client", havingValue = "REST")
public class RestBidClientImpl implements BidClient {

    private final BidService bidService;
    private final BidApiMapper mapper;

    public RestBidClientImpl(BidService bidService, BidApiMapper mapper) {
        this.bidService = bidService;
        this.mapper = mapper;
    }

    @Override
    @PostMapping
    public BidDto create(@RequestBody CreateBidRequest request) {
        return mapper.toResponse(bidService.create(request));
    }

    @Override
    @PostMapping("/approve/{id}")
    public void approve(@PathVariable("id") UUID bidId) {
        bidService.approve(bidId);
    }

    @Override
    @PostMapping("/confirm/{id}")
    public void confirm(@PathVariable("id") UUID bidId) {
        bidService.confirm(bidId);
    }

    @Override
    @PostMapping("/reject/{id}")
    public void reject(@PathVariable("id") UUID bidId) {
        bidService.reject(bidId);
    }

    @Override
    @PostMapping("/cancel/{id}")
    public void cancel(@PathVariable("id") UUID bidId) {
        bidService.cancel(bidId);
    }
}
