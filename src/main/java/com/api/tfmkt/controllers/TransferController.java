package com.api.tfmkt.controllers;

import com.api.tfmkt.models.Transfer;
import com.api.tfmkt.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransferController {
    private TransferService transferService;
    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/player/{id}/transfers")
    public ResponseEntity<List<Transfer>> getPlayerTransfers(@PathVariable Long id) {
        List<Transfer> list = transferService.getTransfersByPlayerID(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/club/{id}/transfers")
    public ResponseEntity<List<Transfer>> getClubTransfers(@PathVariable Long id,
                                                           @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Transfer> transferPage = transferService.getTransfersByClubID(pageable, id);
        return  ResponseEntity.ok(transferPage.getContent());
    }


}
