package com.api.tfmkt.repository;

import com.api.tfmkt.models.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Page<Player> findByNameContains(Pageable pageable, String name);
}
