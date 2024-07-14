package com.api.tfmkt.services;

import com.api.tfmkt.exception.FetchClubLeagueException;
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
        try {
            return clubLeagueRepository.findByClubId(pageable, clubID);
        }catch (Exception e){
            throw new FetchClubLeagueException("[Club League Service] Failed to fetch ClubLeague by clubID"
                    + e.getMessage());
        }
    }

    public Page<ClubLeague> getLeaguesByID(Pageable pageable, String leagueID) {
        try {
            return clubLeagueRepository.findByLeagueId(pageable, leagueID);
        }catch (Exception e){
            throw new FetchClubLeagueException("[Club League Service] Failed to fetch ClubLeague by leagueID"
                    + e.getMessage());
        }
    }
}
