package com.workshop.app.service;

import com.workshop.app.entity.Client;
import com.workshop.app.dto.ClientResponse;
import com.workshop.app.dto.CreateClientRequest;
import com.workshop.app.exception.EmailAlreadyTakenException;
import com.workshop.app.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientResponse createClient(CreateClientRequest request){
        Client entity = new Client(request.firstName(), request.lastName(), request.phoneNumber(), request.email().toLowerCase());
        if(clientRepository.findByEmail(entity.getEmail()) != null){
            throw new EmailAlreadyTakenException(entity.getEmail());
        }
        Client savedClient = clientRepository.save(entity);
    return mapClientToResponse(savedClient);
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
