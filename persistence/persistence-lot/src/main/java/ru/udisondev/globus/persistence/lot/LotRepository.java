package ru.udisondev.globus.persistence.lot;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface LotRepository extends JpaRepository<Lot, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select l from Lot l where l.claimId = ?1")
    Optional<Lot> findByClaimIdForUpdate(UUID claimId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select l from Lot l where l.id = ?1")
    Optional<Lot> findByIdForUpdate(UUID id);

}
