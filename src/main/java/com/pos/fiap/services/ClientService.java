package com.pos.fiap.services;


import com.pos.fiap.dto.ClientDTO;
import com.pos.fiap.entities.Client;
import com.pos.fiap.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientDTO criaConta(ClientDTO clientDTO){
        Client client = new Client(clientDTO.getNome(), clientDTO.getEmail(), clientDTO.getCpf());
        clientRepository.save(client);
        ClientDTO newClientDto = new ClientDTO(client);
        return newClientDto;
    }

    public ClientDTO findClientByCPF(String cpf){
        Client client = clientRepository.findBycpf(cpf);
        return new ClientDTO(client);
    }
}
