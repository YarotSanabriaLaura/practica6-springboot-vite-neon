package com.example.labclients.lab_clients.infrastructure.persistence.adapter;

import com.example.labclients.lab_clients.domain.model.Client;
import com.example.labclients.lab_clients.domain.repository.ClientRepository;
import com.example.labclients.lab_clients.infrastructure.persistence.entity.ClientEntity;
import com.example.labclients.lab_clients.infrastructure.persistence.jpa.SpringDataClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryAdapter implements ClientRepository {

    private final SpringDataClientRepository jpa;

    public ClientRepositoryAdapter(SpringDataClientRepository jpa) {
        this.jpa = jpa;
    }

    private Client toDomain(ClientEntity e) {
        return new Client(e.getId(), e.getName(), e.getEmail(), e.getPhone());
    }

    private ClientEntity toEntity(Client c) {
        return new ClientEntity(c.getId(), c.getName(), c.getEmail(), c.getPhone());
    }

    @Override
    public List<Client> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return jpa.findByEmail(email).map(this::toDomain);
    }

    @Override
    public Client save(Client client) {
        ClientEntity saved = jpa.save(toEntity(client));
        return toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
