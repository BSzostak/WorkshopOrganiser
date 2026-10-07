package com.workshop.app.service;

import com.workshop.app.client.Client;
import com.workshop.app.client.dto.ClientResponse;
import com.workshop.app.client.dto.CreateClientRequest;
import com.workshop.app.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientResponse createClient(CreateClientRequest request){
        Client entity = new Client(request.firstName(), request.lastName(), request.phoneNumber(), request.email());
        Client savedClient = clientRepository.save(entity);
    return new ClientResponse(savedClient.getFirstName(), savedClient.getLastName(), savedClient.getPhoneNumber());
    }

    public List<ClientResponse> getAllClients(){
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> mappedClients = clients.stream()
                .map(ClientService::mapClientToResponse)
                .toList();
        return mappedClients;
    }

    private static ClientResponse mapClientToResponse(Client client){
        return new ClientResponse(client.getFirstName(), client.getLastName(), client.getPhoneNumber());
    }
}
