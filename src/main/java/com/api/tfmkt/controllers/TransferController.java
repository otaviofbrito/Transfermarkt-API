package com.api.tfmkt.controllers;

import com.api.tfmkt.models.Transfer;
import com.api.tfmkt.services.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Transfer", description = "Operations related with transfers")
public class TransferController {
    private TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @Operation(summary = "Get player transfer history",
            description = "Returns the transfer history of the given player ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transfer found!"),
            @ApiResponse(responseCode = "404", description = "Transfer not found!")
    })
    @GetMapping("/player/{id}/transfers")
    public ResponseEntity<List<Transfer>> getPlayerTransfers(@PathVariable Long id) {
        List<Transfer> list = transferService.getTransfersByPlayerID(id);
        return ResponseEntity.ok(list);
    }


    @Operation(summary = "Get club transfer history",
            description = "Returns the transfer history of the given club ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transfers found!"),
            @ApiResponse(responseCode = "404", description = "No transfer found!")
    })
    @GetMapping("/club/{id}/transfers")
    public ResponseEntity<List<Transfer>> getClubTransfers(@PathVariable Long id,
                                                           @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Transfer> transferPage = transferService.getTransfersByClubID(pageable, id);
        return ResponseEntity.ok(transferPage.getContent());
    }


}
