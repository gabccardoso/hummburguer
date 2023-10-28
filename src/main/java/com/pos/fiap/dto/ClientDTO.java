package com.pos.fiap.dto;

import com.pos.fiap.entities.Client;

public class ClientDTO {

    private String nome;
    private String email;
    private String cpf;

    public ClientDTO(){}

    public ClientDTO(Client client) {
        nome = client.getNome();
        email = client.getEmail();
        cpf = client.getCpf();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
