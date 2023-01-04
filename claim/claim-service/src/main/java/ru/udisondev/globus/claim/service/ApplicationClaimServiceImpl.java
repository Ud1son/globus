package ru.udisondev.globus.claim.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.udisondev.globus.claim.publisher.ClaimEventPublisher;
import ru.udisondev.globus.claim.service.model.ClaimDataProvider;
import ru.udisondev.globus.claim.service.model.ClaimInfo;
import ru.udisondev.globus.exception.ClaimNotFoundException;
import ru.udisondev.globus.persistence.claim.Claim;
import ru.udisondev.globus.persistence.claim.ClaimRepository;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static ru.udisondev.globus.persistence.enums.ClaimState.*;

@Service
public class ApplicationClaimServiceImpl implements ClaimService {

    private final ClaimRepository repository;
    private final ClaimServiceMapper mapper;
    private final ClaimEventPublisher eventPublisher;

    public ApplicationClaimServiceImpl(ClaimRepository repository, ClaimServiceMapper mapper, ClaimEventPublisher eventPublisher) {
        this.repository = repository;
        this.mapper = mapper;
        this.eventPublisher = eventPublisher;
    }


    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ClaimInfo create(ClaimDataProvider dataProvider) {
        var savedClaim = repository.saveAndFlush(mapper.toEntity(dataProvider));
        eventPublisher.publish(mapper.toEvent(savedClaim));

        return mapper.toDto(savedClaim);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void complete(UUID claimId) {
        updateClaimStateWithEventPublishing(
                claimId,
                claim -> claim.setState(COMPLETED),
                claim -> claim.getState() == NEW);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void cancel(UUID claimId) {
        updateClaimStateWithEventPublishing(
                claimId,
                claim -> claim.setState(CANCELLED),
                claim -> claim.getState() == NEW);
    }

    private void updateClaimStateWithEventPublishing(UUID claimId, Consumer<Claim> updateFunc, Predicate<Claim> possibleResolver) {
        var claim = repository.findByIdForUpdate(claimId).orElseThrow(() -> ClaimNotFoundException.byId(claimId));
        if (!possibleResolver.test(claim)) {
            return;
        }
        updateFunc.accept(claim);
        var updatedClaim = repository.save(claim);
        eventPublisher.publish(mapper.toEvent(updatedClaim));
    }
}
