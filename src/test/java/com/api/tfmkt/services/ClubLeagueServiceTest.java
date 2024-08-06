package com.api.tfmkt.services;

import com.api.tfmkt.exception.ClubLeagueNotFoundException;
import com.api.tfmkt.repository.ClubLeagueRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

@ExtendWith(MockitoExtension.class)
public class ClubLeagueServiceTest {

    @InjectMocks
    private ClubLeagueService clubLeagueService;

    @Mock
    private ClubLeagueRepository clubLeagueRepository;

    private Pageable pageable = PageRequest.of(0, 20);

    @Test
    @DisplayName("#getClubsByID > when given id is null > Throw IllegalArgumentException")
    public void getClubsByIDWhenGivenIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> clubLeagueService.getClubsByID(pageable, null));
    }

    @Test
    @DisplayName("#getClubsByID > When there is no club with given id >  Throw ClubLeagueNotFoundException")
    public void getClubsByIDWhenThereIsNoClubWithGivenId() {
        Long clubId = 123L;
        Mockito.when(clubLeagueRepository.findByClubId(pageable, clubId)).thenReturn(Page.empty());
        Assertions.assertThrows(ClubLeagueNotFoundException.class,
                () -> clubLeagueService.getClubsByID(pageable, clubId));
    }

    @Test
    @DisplayName("getLeaguesByID > When given id is null > Throw IllegalArgumentException")
    public void getLeaguesByIDWhenGivenIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> clubLeagueService.getLeaguesByID(pageable, null));
    }

    @Test
    @DisplayName("#getLeaguesByID > When there is no league with given id > Throw ClubLeagueNotFoundException")
    public void getLeaguesByIDWhenThereIsNoLeagueWithGivenId() {
        String leagueID = "GB1";
        Mockito.when(clubLeagueRepository.findByLeagueId(pageable, leagueID)).thenReturn(Page.empty());
        Assertions.assertThrows(ClubLeagueNotFoundException.class,
                () -> clubLeagueService.getLeaguesByID(pageable, leagueID));

    }
}
