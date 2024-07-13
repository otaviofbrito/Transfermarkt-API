package com.api.tfmkt.services;

import com.api.tfmkt.exception.FetchTransferException;
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

    public List<Transfer> getTransfersByPlayerID(Long playerID) {
        try {
            return transferRepository.findByPlayerId(playerID);
        }catch (Exception e){
            throw new FetchTransferException("[TransferService] failed to fetch transfer by player ID: "
                    + e.getMessage());
        }
    }

    public Page<Transfer> getTransfersByClubID(Pageable pageable, Long clubID) {
        try {
            return transferRepository.findByJoinedClubIdOrLeftClubId(pageable, clubID);
        } catch (Exception e){
            throw new FetchTransferException("[TransferService] failed to fetch transfer by Club ID: "+e.getMessage());
        }
    }


}
