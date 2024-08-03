package com.api.tfmkt.repository;

import com.api.tfmkt.models.ClubLeague;
import com.api.tfmkt.models.ClubLeaguePK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
    public interface ClubLeagueRepository extends JpaRepository<ClubLeague, ClubLeaguePK> {
    Page<ClubLeague> findByClubId(Pageable pageable, Long clubId);

    Page<ClubLeague> findByLeagueId(Pageable pageable, String leagueId);
}
