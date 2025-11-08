package com.example.labclients.lab_clients.application.service;

import com.example.labclients.lab_clients.domain.model.Client;
import com.example.labclients.lab_clients.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repo;

    public ClientService(ClientRepository repo) { this.repo = repo; }

    @Transactional(readOnly = true)
    public List<Client> getAll() { return repo.findAll(); }

    @Transactional(readOnly = true)
    public Client getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Transactional
    public Client create(Client client) {
        repo.findByEmail(client.getEmail()).ifPresent(c -> { throw new RuntimeException("Email already exists"); });
        return repo.save(client);
    }

    @Transactional
    public Client update(Long id, Client data) {
        Client current = getById(id);
        current.setName(data.getName());
        current.setEmail(data.getEmail());
        current.setPhone(data.getPhone());
        return repo.save(current);
    }

    @Transactional
    public void delete(Long id) { repo.deleteById(id); }
}
