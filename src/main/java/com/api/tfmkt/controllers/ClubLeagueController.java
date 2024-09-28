package com.api.tfmkt.controllers;

import com.api.tfmkt.models.ClubLeague;
import com.api.tfmkt.services.ClubLeagueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "ClubLeague", description = "Operations related to the relationship between clubs and leagues.")
public class ClubLeagueController {
    private ClubLeagueService clubLeagueService;

    @Autowired
    private ClubLeagueController(ClubLeagueService service) {
        this.clubLeagueService = service;
    }


    @Operation(summary = "Get clubs that are part of a league",
            description = "Returns all clubs currently playing in the league.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Club found!"),
            @ApiResponse(responseCode = "404", description = "No club found!")
    })
    @GetMapping("/league/{id}/clubs")
    public ResponseEntity<List<ClubLeague>> getClubsById(@PathVariable String id,
                                                         @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<ClubLeague> clubLeaguePage = clubLeagueService.getLeaguesByID(pageable, id);
        return ResponseEntity.ok(clubLeaguePage.getContent());
    }

    @Operation(summary = "Get leagues that a club has played in",
            description = "Returns all leagues that the club has played in.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "League found!"),
            @ApiResponse(responseCode = "404", description = "No league found!")
    })
    @GetMapping("/club/{id}/leagues")
    public ResponseEntity<List<ClubLeague>> getLeaguesByID(@PathVariable Long id,
                                                           @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<ClubLeague> clubLeaguePage = clubLeagueService.getClubsByID(pageable, id);
        return ResponseEntity.ok(clubLeaguePage.getContent());
    }
}
