package com.api.tfmkt.controllers;

import com.api.tfmkt.models.League;
import com.api.tfmkt.services.LeagueService;
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
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "League", description = "Operations related to leagues (competitions).")
public class LeagueController {
    private LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }


    @Operation(summary = "Get league information",
            description = "Returns information about the league.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "League found!"),
            @ApiResponse(responseCode = "404", description = "No league found!")
    })
    @GetMapping("/league/{id}/info")
    public ResponseEntity<League> getLeagueById(@PathVariable(value = "id") String id) {
        Optional<League> leagueOptional = leagueService.getLeague(id);
        return leagueOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Search for a league by name",
            description = "Returns a list of leagues with matching names.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "League found!"),
            @ApiResponse(responseCode = "404", description = "No league found!")
    })
    @GetMapping("/league/search/{name}")
    public ResponseEntity<List<League>> getLeagueByName(@PathVariable(value = "name") String name,
                                                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<League> leaguePage = leagueService.getLeagueByName(pageable, name);
        return ResponseEntity.ok(leaguePage.getContent());
    }

}
