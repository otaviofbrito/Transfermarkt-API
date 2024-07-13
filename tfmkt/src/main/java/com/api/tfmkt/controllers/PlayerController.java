package com.api.tfmkt.controllers;

import com.api.tfmkt.models.Player;
import com.api.tfmkt.services.PlayerService;
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
public class PlayerController {
    private PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/player/{id}/profile")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") BigInteger id) {
        Optional<Player> playerOptional = playerService.getPlayerById(id);
        return playerOptional.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());

    }

    @GetMapping("/player/search/{name}")
    public ResponseEntity<List<Player>> getPlayerByName(@PathVariable("name") String name,
                                                        @RequestParam(defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Player> playerPage = playerService.getPlayerByName(pageable, name);
        return ResponseEntity.ok(playerPage.getContent());
    }

}
