package com.api.tfmkt.services;

import com.api.tfmkt.exception.FetchLeagueException;
import com.api.tfmkt.models.League;
import com.api.tfmkt.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeagueService {

    private LeagueRepository leagueRepository;
    @Autowired
    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public Optional<League> getLeague(String leagueId) {
        try {
            return leagueRepository.findById(leagueId);
        }catch (Exception e){
            throw new FetchLeagueException("[LeagueService] Failed to fetch League by ID: " + e.getMessage());
        }
    }
}
