package com.api.tfmkt.controllers;

import com.api.tfmkt.models.ClubLeague;
import com.api.tfmkt.services.ClubLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClubLeagueController {
    private ClubLeagueService clubLeagueService;
    @Autowired
    private ClubLeagueController(ClubLeagueService service) {
        this.clubLeagueService = service;
    }

    @GetMapping("/league/{id}/clubs")
    public ResponseEntity<List<ClubLeague>> getClubsById(@PathVariable String id,
                                                           @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<ClubLeague> clubLeaguePage = clubLeagueService.getLeaguesByID(pageable, id);
        return ResponseEntity.ok(clubLeaguePage.getContent());
    }

    @GetMapping("/club/{id}/leagues")
    public ResponseEntity<List<ClubLeague>> getLeaguesByID(@PathVariable Long id,
                                                           @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 20);
        Page<ClubLeague> clubLeaguePage = clubLeagueService.getClubsByID(pageable, id);
        return ResponseEntity.ok(clubLeaguePage.getContent());
    }
}
