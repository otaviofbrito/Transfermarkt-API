package com.api.tfmkt.services;

import com.api.tfmkt.exception.TransferNotFoundException;
import com.api.tfmkt.repository.TransferRepository;
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

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTest {

    @InjectMocks
    private TransferService transferService;

    @Mock
    private TransferRepository transferRepository;

    @Test
    @DisplayName("#getTransferByPlayerID > When given id is null > Throw IllegalArgumentException")
    public void getTransferByPlayerIDWhenGivenIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> transferService.getTransfersByPlayerID(null));
    }

    @Test
    @DisplayName("#getTransferByPlayerID > When there is no transfer with given player ID > Throw TransferNotFoundException")
    public void getTransferByPlayerIDWhenThereIsNoTransferWithGivenPlayerID() {
        Long playerId = 123L;
        Mockito.when(transferRepository.findByPlayerId(playerId)).thenReturn(new ArrayList<>());
        Assertions.assertThrows(TransferNotFoundException.class,
                () -> transferService.getTransfersByPlayerID(playerId));
    }

    @Test
    @DisplayName("#getTransfersByClubID > When given club id is null > Throw IllegalArgumentException")
    public void getTransfersByClubIDWhenGivenClubIdIsNull() {
        Pageable pageable = PageRequest.of(0, 20);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> transferService.getTransfersByClubID(pageable, null));
    }

    @Test
    @DisplayName("#getTransferByClubID > When there is no transfer with given club id > Throw TransferNotFoundException")
    public void getTransferByClubIDWhenThereIsNoTransferWithGivenClubId() {
        Long clubId = 123L;
        Pageable pageable = PageRequest.of(0, 20);
        Mockito.when(transferRepository.findByJoinedClubIdOrLeftClubId(pageable, clubId)).thenReturn(Page.empty());
        Assertions.assertThrows(TransferNotFoundException.class,
                () -> transferService.getTransfersByClubID(pageable, clubId));
    }

}
