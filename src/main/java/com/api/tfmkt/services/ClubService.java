package com.api.tfmkt.services;

import com.api.tfmkt.exception.FetchClubException;
import com.api.tfmkt.models.Club;
import com.api.tfmkt.repository.ClubRepository;
import com.api.tfmkt.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
        try {
            return clubRepository.findById(id);
        }catch (Exception e){
            throw new FetchClubException("[ClubService] Error getting club by id: " + e.getMessage());
        }
    }

    public Page<Club> getClubByName(Pageable pageable, String name) {
        try {
            return clubRepository.findByNameContains(pageable, name);
        }catch (Exception e){
            throw new FetchClubException("[ClubService] Error getting club by name: " + e.getMessage());
        }
    }

}
