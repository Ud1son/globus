package ru.udisondev.globus.persistence.claim;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClaimRepository extends JpaRepository<Claim, ClaimId> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select c from Claim c where c.id = ?1")
    Optional<Claim> findByIdForUpdate(ClaimId claimId);
}
