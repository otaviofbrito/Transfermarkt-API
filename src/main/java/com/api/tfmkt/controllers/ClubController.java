package com.api.tfmkt.controllers;

import com.api.tfmkt.models.Club;
import com.api.tfmkt.services.ClubService;
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
@Tag(name = "Club", description = "Operations related to clubs.")

public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @Operation(summary = "Get information about a club",
            description = "Returns data for the club with the given ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Club found!"),
            @ApiResponse(responseCode = "404", description = "No club found!")
    })
    @GetMapping("/club/{id}/info")
    public ResponseEntity<Club> getClubById(@PathVariable Long id) {
        Optional<Club> clubOptional = clubService.getClubById(id);
        return clubOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(summary = "Search for a club by its name",
            description = "Returns a list of clubs with matching names.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Club found!"),
            @ApiResponse(responseCode = "404", description = "No club found!")
    })
    @GetMapping("/club/search/{name}")
    public ResponseEntity<List<Club>> getClubByName(@PathVariable String name,
                                                    @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Club> clubPage = clubService.getClubByName(pageable, name);
        return ResponseEntity.ok(clubPage.getContent());
    }
}
