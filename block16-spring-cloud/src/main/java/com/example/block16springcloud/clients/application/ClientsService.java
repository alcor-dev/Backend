package com.example.block16springcloud.clients.application;

import com.example.block16springcloud.clients.domain.Clients;
import com.example.block16springcloud.clients.infrastructure.controller.dto.ClientsInputDTO;
import com.example.block16springcloud.clients.infrastructure.controller.dto.ClientsOutputDTO;

import java.util.List;

public interface ClientsService {

    void createClients(ClientsInputDTO clientsInputDTO);
    ClientsOutputDTO readClients(Integer idClients);
    List<ClientsOutputDTO> readAllClients();
    void updateClients(ClientsInputDTO clientsInputDTO);
    void deleteClients(Integer idClients);
}
