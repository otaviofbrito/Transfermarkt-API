package com.api.tfmkt.repository;

import com.api.tfmkt.models.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ClubRepository extends JpaRepository<Club, BigInteger> {

    Page<Club> findByNameContains(Pageable pageable, String name);
}
