package com.api.tfmkt.services;

import com.api.tfmkt.exception.LeagueNotFoundException;
import com.api.tfmkt.models.League;
import com.api.tfmkt.repository.LeagueRepository;
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
public class LeagueServiceTest {

    @InjectMocks
    private LeagueService leagueService;

    @Mock
    private LeagueRepository leagueRepository;

    @Test
    @DisplayName("#getLeague > When there is no league with specified ID > throw LeagueNotFoundException")
    public void getLeagueByIdWhenThereIsNoLeague() {
        String leagueId = "GB1";
        Mockito.when(leagueRepository.findById(leagueId)).thenReturn(Optional.empty());
        Assertions.assertThrows(LeagueNotFoundException.class,
                () -> leagueService.getLeague(leagueId));
    }

    @Test
    @DisplayName("#getLeague > When the id is null > throw IllegalArgumentException")
    public void getLeagueByIdWhenIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> leagueService.getLeague(null));
    }

    @Test
    @DisplayName("#getLeagueByName > When there is no league with given name > throw LeagueNotFoundException")
    public void getLeagueByNameWhenThereIsNoLeague() {
        String leagueName = "Premier League";
        Pageable pageable = PageRequest.of(0, 20);
        Mockito.when(leagueRepository.findByNameContaining(pageable, leagueName)).thenReturn(Page.empty());
        Assertions.assertThrows(LeagueNotFoundException.class,
                () -> leagueService.getLeagueByName(pageable, leagueName));

    }

    @Test
    @DisplayName("getLeagueByName > When name is null > throw IllegalArgumentException")
    public void getLeagueByNameWhenNameIsNull() {
        Pageable pageable = PageRequest.of(0, 20);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> leagueService.getLeagueByName(pageable, null));
    }

}
