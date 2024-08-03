package com.api.tfmkt.services;

import com.api.tfmkt.exception.ClubLeagueNotFoundException;
import com.api.tfmkt.models.ClubLeague;
import com.api.tfmkt.repository.ClubLeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClubLeagueService {
    private ClubLeagueRepository clubLeagueRepository;
    @Autowired
    public ClubLeagueService(ClubLeagueRepository clubLeagueRepository) {
        this.clubLeagueRepository = clubLeagueRepository;
    }

    public Page<ClubLeague> getClubsByID(Pageable pageable, Long clubID) {
        Page<ClubLeague> page = clubLeagueRepository.findByClubId(pageable, clubID);
        if (page.isEmpty()){
            throw new ClubLeagueNotFoundException("No League found for club ID: " + clubID);
        }
        return page;
    }

    public Page<ClubLeague> getLeaguesByID(Pageable pageable, String leagueID) {
       Page<ClubLeague> page = clubLeagueRepository.findByLeagueId(pageable, leagueID);
       if (page.isEmpty()){
           throw new ClubLeagueNotFoundException("No Club found for league ID: " + leagueID);
       }
       return page;
    }
}
