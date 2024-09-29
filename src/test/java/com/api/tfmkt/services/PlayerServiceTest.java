package com.api.tfmkt.services;

import com.api.tfmkt.exception.PlayerNotFoundException;
import com.api.tfmkt.repository.PlayerRepository;
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
public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    @DisplayName("#getPlayerById > When player id is null > throw IllegalArgumentException")
    public void getPlayerByIdWhenPlayerIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> playerService.getPlayerById(null));
    }

    @Test
    @DisplayName("#getPlayerById > When there is no player with given id > throw PlayerNotFoundException")
    public void getPlayerByIdWhenPlayerWithGivenIdIsNull() {
        Long id = 123L;
        Mockito.when(playerRepository.findById(123L)).thenReturn(null);
        Assertions.assertThrows(PlayerNotFoundException.class,
                () -> playerService.getPlayerById(id));
    }

    @Test
    @DisplayName("#getPlayerByName > When there is no player with given name > throw PlayerNotFoundException")
    public void getPlayerByNameWhenPlayerWithGivenNameIsNull() {
        Pageable pageable = PageRequest.of(0, 20);
        String name = "Otavio";
        Mockito.when(playerRepository.findByNameContains(pageable, name)).thenReturn(Page.empty());
        Assertions.assertThrows(PlayerNotFoundException.class,
                () -> playerService.getPlayerByName(pageable, name));
    }

    @Test
    @DisplayName("#getPlayerByName > When given name is null > throw IllegalArgumentException")
    public void getPlayerByNameWhenGivenNameIsNull() {
        Pageable pageable = PageRequest.of(0, 20);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> playerService.getPlayerByName(pageable, null));
    }

}
