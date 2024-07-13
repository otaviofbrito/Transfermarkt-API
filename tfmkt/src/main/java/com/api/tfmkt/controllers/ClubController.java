package com.api.tfmkt.controllers;

import com.api.tfmkt.models.Club;
import com.api.tfmkt.services.ClubService;
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
public class ClubController {
    private ClubService clubService;
    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/club/{id}/profile")
    public ResponseEntity<Optional<Club>> getClubById(@PathVariable BigInteger id) {
        Optional<Club> clubOptional = clubService.getClubById(id);
        if (clubOptional.isPresent()) {
            return ResponseEntity.ok(clubOptional);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/club/search/{name}")
    public ResponseEntity<List<Club>> getClubByName(@PathVariable String name,
                                                    @RequestParam(defaultValue = "0") int page)
    {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Club> clubPage = clubService.getClubByName(pageable, name);
        return ResponseEntity.ok(clubPage.getContent());
    }
}
