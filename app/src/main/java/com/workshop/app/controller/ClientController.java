package com.workshop.app.controller;

import com.workshop.app.dto.ClientResponse;
import com.workshop.app.dto.CreateClientRequest;
import com.workshop.app.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @Transactional
    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody CreateClientRequest request) {
        ClientResponse savedClient = clientService.createClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }
    @Transactional
    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients(){
        List<ClientResponse> clients = clientService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }
}
