package com.pos.fiap.repository;

import com.pos.fiap.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findBycpf(String cpf);
}
