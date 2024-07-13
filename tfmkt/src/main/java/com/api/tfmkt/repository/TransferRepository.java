package com.api.tfmkt.repository;

import com.api.tfmkt.models.Transfer;
import com.api.tfmkt.models.TransferPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, TransferPK> {
    List<Transfer> findByPlayerId(Long playerID);

    @Query("SELECT t FROM Transfer t WHERE t.joinedClub.id = :clubID OR t.leftClub.id = :clubID")
    Page<Transfer> findByJoinedClubIdOrLeftClubId(Pageable pageable, Long clubID);
}
