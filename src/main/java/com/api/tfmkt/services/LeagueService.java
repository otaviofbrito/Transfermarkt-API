package com.api.tfmkt.services;

import com.api.tfmkt.exception.LeagueNotFoundException;
import com.api.tfmkt.models.League;
import com.api.tfmkt.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Optional<League> optionalLeague = leagueRepository.findById(leagueId);
        if (optionalLeague.isEmpty()){
            throw new LeagueNotFoundException("League with id " + leagueId + " not found!");
        }
        return optionalLeague;
    }

    public Page<League> getLeagueByName(Pageable pageable, String name) {
        Page<League> page = leagueRepository.findByNameContaining(pageable, name);
        if (page.isEmpty()){
            throw new LeagueNotFoundException("League with name " + name + " not found!");
        }
        return page;
    }
}
