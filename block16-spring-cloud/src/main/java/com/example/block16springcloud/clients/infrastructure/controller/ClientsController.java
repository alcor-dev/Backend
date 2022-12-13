package com.example.block16springcloud.clients.infrastructure.controller;

import com.example.block16springcloud.clients.application.ClientsServiceImpl;

import com.example.block16springcloud.clients.infrastructure.controller.dto.ClientsInputDTO;
import com.example.block16springcloud.clients.infrastructure.controller.dto.ClientsOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientsServiceImpl clientsService;

    @PostMapping
    public String addClients(@RequestBody ClientsInputDTO clientsInputDTO) {
        clientsService.createClients(clientsInputDTO);
        return "Creado el cliente: " + clientsInputDTO.getFirstName();
    }

    @GetMapping("/{id}")
    public ClientsOutputDTO readClient(@PathVariable("id") Integer idClient) {
        return clientsService.readClients(idClient);
    }

    @GetMapping
    public List<ClientsOutputDTO> readAllClients() {
        return clientsService.readAllClients();
    }

    @PutMapping
    public String updateClient(@RequestBody ClientsInputDTO clientsInputDTO) {
        clientsService.updateClients(clientsInputDTO);
        return "El cliente " + clientsInputDTO.getFirstName() + " ha sido actualizado";
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Integer idClients) {
        clientsService.deleteClients(idClients);
        return "El cliente de ID " + idClients + " ha sido eliminado";
    }
}