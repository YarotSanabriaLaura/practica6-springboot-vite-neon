package com.example.labclients.lab_clients.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientDTO {
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    @Email
    @Size(max = 30)
    private String email;

    @Size(max = 20)
    private String phone;

    public ClientDTO() {}

    public ClientDTO(Long id, String name, String email, String phone) {
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
