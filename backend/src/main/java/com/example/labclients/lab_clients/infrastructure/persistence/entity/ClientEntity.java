package com.example.labclients.lab_clients.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clients",
        uniqueConstraints = @UniqueConstraint(name = "uk_client_email", columnNames = "email"))
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(length = 20)
    private String phone;

    public ClientEntity() {}

    public ClientEntity(Long id, String name, String email, String phone) {
        this.id = id; this.name = name; this.email = email; this.phone = phone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
