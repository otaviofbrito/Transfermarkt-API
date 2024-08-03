package com.api.tfmkt.services;

import com.api.tfmkt.exception.ClubNotFoundException;
import com.api.tfmkt.models.Club;
import com.api.tfmkt.repository.ClubRepository;
import com.api.tfmkt.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClubService {
    private final LeagueRepository leagueRepository;
    private ClubRepository clubRepository;
    @Autowired
    public ClubService(ClubRepository clubRepository, LeagueRepository leagueRepository) {
        this.clubRepository = clubRepository;
        this.leagueRepository = leagueRepository;
    }

    public Optional<Club> getClubById(Long id) {
        Optional<Club> clubOptional = clubRepository.findById(id);
        if (clubOptional.isEmpty()){
            throw new ClubNotFoundException("Club with id " + id + " not found!");
        }
        return clubOptional;
    }

    public Page<Club> getClubByName(Pageable pageable, String name) {
        Page<Club> page = clubRepository.findByNameContains(pageable, name);
        if (page.isEmpty()){
            throw new ClubNotFoundException("Club with name " + name + " not found!");
        }
        return page;
    }

}
