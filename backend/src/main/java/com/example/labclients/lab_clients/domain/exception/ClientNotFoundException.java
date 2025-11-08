package com.example.labclients.lab_clients.domain.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super("Client not found: " + id);
    }
}
