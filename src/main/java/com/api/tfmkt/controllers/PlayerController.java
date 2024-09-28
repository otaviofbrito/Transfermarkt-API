package com.api.tfmkt.controllers;

import com.api.tfmkt.models.Player;
import com.api.tfmkt.services.PlayerService;
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

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "Player", description = "Operations related to players.")
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Operation(summary = "Get player data", description = "Returns all the information about a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player found!"),
            @ApiResponse(responseCode = "404", description = "Player not found!")
    })
    @GetMapping("/player/{id}/profile")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id) {
        Optional<Player> playerOptional = playerService.getPlayerById(id);
        return playerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @Operation(summary = "Search for a player by name",
            description = "Returns a list of players with matching names.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player found!"),
            @ApiResponse(responseCode = "404", description = "No player found!")
    })
    @GetMapping("/player/search/{name}")
    public ResponseEntity<List<Player>> getPlayerByName(@PathVariable("name") String name,
                                                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Player> playerPage = playerService.getPlayerByName(pageable, name);
        return ResponseEntity.ok(playerPage.getContent());
    }

}
