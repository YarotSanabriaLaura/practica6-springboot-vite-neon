package com.example.labclients.lab_clients.infrastructure.rest;

import com.example.labclients.lab_clients.application.dto.ClientDTO;
import com.example.labclients.lab_clients.application.mapper.ClientMapper;
import com.example.labclients.lab_clients.application.service.ClientService;
import com.example.labclients.lab_clients.domain.model.Client;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin // si usas Vite en localhost:5173 no tendrás problemas
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService service;
    private final ClientMapper mapper;

    public ClientController(ClientService service, ClientMapper mapper) {
        this.service = service; this.mapper = mapper;
    }

    @GetMapping
    public List<ClientDTO> findAll() {
        return service.getAll().stream().map(mapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return mapper.toDTO(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO dto) {
        Client saved = service.create(mapper.toDomain(dto));
        return ResponseEntity
                .created(URI.create("/api/clients/" + saved.getId()))
                .body(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
        return mapper.toDTO(service.update(id, mapper.toDomain(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

