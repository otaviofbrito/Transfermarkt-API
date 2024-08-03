package com.api.tfmkt.services;

import com.api.tfmkt.exception.PlayerNotFoundException;
import com.api.tfmkt.models.Player;
import com.api.tfmkt.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Optional<Player> getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isEmpty()) {
            throw new PlayerNotFoundException("Player with ID: " + id + " not found!");
        }
        return player;
    }

    public Page<Player> getPlayerByName(Pageable pageable, String name) {
        Page<Player> page = playerRepository.findByNameContains(pageable, name);
        if (page.isEmpty()) {
            throw new PlayerNotFoundException("Player with name: " + name + " not found!");
        }
        return page;
    }
}
