package com.api.tfmkt.controllers;

import com.api.tfmkt.models.League;
import com.api.tfmkt.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LeagueController {
    private LeagueService leagueService;
    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/league/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable( value = "id") String id) {
        Optional<League> leagueOptional = leagueService.getLeague(id);
        return leagueOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
