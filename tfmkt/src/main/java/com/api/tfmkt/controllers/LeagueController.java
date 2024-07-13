package com.api.tfmkt.controllers;

import com.api.tfmkt.models.League;
import com.api.tfmkt.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LeagueController {
    private LeagueService leagueService;
    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/league/{id}/info")
    public ResponseEntity<League> getLeagueById(@PathVariable( value = "id") String id) {
        Optional<League> leagueOptional = leagueService.getLeague(id);
        return leagueOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/league/search/{name}")
    public ResponseEntity<List<League>> getLeagueByName(@PathVariable( value = "name") String name,
                                                  @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<League> leaguePage = leagueService.getLeagueByName(pageable, name);
        return ResponseEntity.ok(leaguePage.getContent());
        }

}
