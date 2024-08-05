package com.api.tfmkt.services;

import com.api.tfmkt.exception.ClubNotFoundException;
import com.api.tfmkt.repository.ClubRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClubServiceTest {

    @InjectMocks
    private ClubService clubService;

    @Mock
    private ClubRepository clubRepository;

    @Test
    @DisplayName("#getClubById > When id doest not exists > throw ClubNotFoundException")
    public void getCluByIdWhenIdDoesNotExists() {
        Long id = 1234L;
        Mockito.when(clubRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ClubNotFoundException.class,
                () -> clubService.getClubById(id));
    }

    @Test
    @DisplayName("#getClubById > When id is null > throw IllegalArgumentException")
    public void getClubByIdWhenIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> clubService.getClubById(null));
    }

    @Test
    @DisplayName("#getClubByName > When name does not exists > throw ClubNotFoundException")
    public void getClubByNameWhenNameDoesNotExists() {
        String name = "test";
        Pageable pageable = PageRequest.of(0 ,20);
        Mockito.when(clubRepository.findByNameContains(pageable, name)).thenReturn(Page.empty());
        Assertions.assertThrows(ClubNotFoundException.class,
                () -> clubService.getClubByName(pageable, name));

    }

    @Test
    @DisplayName("#getClubByName > whe name is null > throw IllegalArgumentException")
    public void getClubByNameWhenNameIsNull() {
        Pageable pageable = PageRequest.of(0 ,20);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> clubService.getClubByName(pageable, null));
    }

}
