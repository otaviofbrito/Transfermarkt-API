package com.api.tfmkt.services;

import com.api.tfmkt.exception.TransferNotFoundException;
import com.api.tfmkt.models.Transfer;
import com.api.tfmkt.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {
    private TransferRepository transferRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public List<Transfer> getTransfersByPlayerID(Long playerID) throws TransferNotFoundException {
        List<Transfer> transferList = transferRepository.findByPlayerId(playerID);
        if (transferList.isEmpty()) {
            throw new TransferNotFoundException("No transfer found for player ID: " + playerID);
        }
        return transferList;
    }

    public Page<Transfer> getTransfersByClubID(Pageable pageable, Long clubID) {
        Page<Transfer> page =  transferRepository.findByJoinedClubIdOrLeftClubId(pageable, clubID);
        if (page.isEmpty()) {
            throw new TransferNotFoundException("No transfer found for club ID: " + clubID);
        }
        return page;
    }


}
