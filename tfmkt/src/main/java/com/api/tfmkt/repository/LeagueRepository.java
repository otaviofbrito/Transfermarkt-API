package com.api.tfmkt.repository;

import com.api.tfmkt.models.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, String> {

}
