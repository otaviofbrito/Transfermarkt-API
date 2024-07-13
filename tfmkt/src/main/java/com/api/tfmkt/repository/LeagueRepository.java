package com.api.tfmkt.repository;

import com.api.tfmkt.models.League;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, String> {
    Optional<League> findByUrl(String url);

    Page<League> findByNameContaining(Pageable pageable, String name);

    //TODO: get list of clubs in league
}
