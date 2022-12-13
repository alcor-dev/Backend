package com.example.block16springcloud.clients.application;

import com.example.block16springcloud.clients.domain.Clients;
import com.example.block16springcloud.clients.infrastructure.controller.dto.ClientsInputDTO;
import com.example.block16springcloud.clients.infrastructure.controller.dto.ClientsOutputDTO;
import com.example.block16springcloud.clients.infrastructure.repository.ClientsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public void createClients(ClientsInputDTO clientsInputDTO) {
        clientsRepository.save(new Clients(clientsInputDTO));
    }

    @Override
    public ClientsOutputDTO readClients(Integer idClients) {
        Clients client = clientsRepository.findById(idClients).orElseThrow(() -> new EntityNotFoundException());
        return new ClientsOutputDTO(client);
    }

    @Override
    public List<ClientsOutputDTO> readAllClients() {
        List<Clients> listClients = clientsRepository.findAll();
        List<ClientsOutputDTO> listOutput = new ArrayList<>();
        listClients.stream().forEach(client -> listOutput.add(new ClientsOutputDTO(client)));
        return listOutput;
    }

    @Override
    public void updateClients(ClientsInputDTO clientsInputDTO) {
        clientsRepository.save(new Clients(clientsInputDTO));
    }

    @Override
    public void deleteClients(Integer idClients) {
        clientsRepository.deleteById(idClients);
    }
}
