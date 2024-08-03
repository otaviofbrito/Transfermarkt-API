package com.api.tfmkt.services;

import com.api.tfmkt.exception.FetchPlayerException;
import com.api.tfmkt.models.Player;
import com.api.tfmkt.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Optional<Player> getPlayerById(Long id) {
        try{
            return playerRepository.findById(id);
        }catch (Exception e){
            throw new FetchPlayerException("[PlayerService] failed to fetch player by id: " + e.getMessage());
        }
    }

    public Page<Player> getPlayerByName(Pageable pageable, String name) {
        try {
            return playerRepository.findByNameContains(pageable, name);
        }catch (Exception e){
            throw new FetchPlayerException("[PlayerService] failed to fetch player by name:" + e.getMessage());
        }
    }
}
