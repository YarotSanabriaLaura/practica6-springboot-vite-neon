package com.example.labclients.lab_clients.domain.repository;

import com.example.labclients.lab_clients.domain.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    Optional<Client> findByEmail(String email);
    Client save(Client client);
    void deleteById(Long id);
}
