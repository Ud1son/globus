package ru.udisondev.globus.persistence.bid;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BidRepository extends JpaRepository<Bid, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select b from Bid b where b.id = ?1")
    Optional<Bid> findByIdForUpdate(UUID id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Bid> findAllByLotId(UUID lotId);

    @Query("select b from Bid b where b.lotId = ?1 and b.id <> ?2")
    List<Bid> findAllByLotIdExcludeConfirmedBid(UUID lotId, UUID confirmedBidId);
}

