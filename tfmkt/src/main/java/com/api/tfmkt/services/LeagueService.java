package com.api.tfmkt.services;

import com.api.tfmkt.exception.FetchLeagueException;
import com.api.tfmkt.models.League;
import com.api.tfmkt.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Optional<League> getLeagueByUrl(String url) {
        try {
            return leagueRepository.findByUrl(url);
        }catch (Exception e){
        throw new FetchLeagueException("[LeagueService] Failed to fetch League by URL: " + e.getMessage());
        }
    }

    public Page<League> getLeagueByName(Pageable pageable, String name) {
        try {
            return leagueRepository.findByNameContaining(pageable, name);
        }catch (Exception e){
            throw new FetchLeagueException("[LeagueService] Failed to fetch League by name: " + e.getMessage());
        }
    }
}
