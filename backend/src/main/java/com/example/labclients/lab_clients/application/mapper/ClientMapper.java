package com.example.labclients.lab_clients.application.mapper;

import com.example.labclients.lab_clients.application.dto.ClientDTO;
import com.example.labclients.lab_clients.domain.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDTO toDTO(Client c) {
        return new ClientDTO(c.getId(), c.getName(), c.getEmail(), c.getPhone());
    }
    public Client toDomain(ClientDTO d) {
        return new Client(d.getId(), d.getName(), d.getEmail(), d.getPhone());
    }
}
