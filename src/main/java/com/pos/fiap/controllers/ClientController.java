package com.pos.fiap.controllers;

import com.pos.fiap.dto.ClientDTO;
import com.pos.fiap.entities.Client;
import com.pos.fiap.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(value = "/cadastro")
    public ResponseEntity<ClientDTO> cadastroClient(@RequestBody ClientDTO clientDTO){
        clientDTO = clientService.criaConta(clientDTO);
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping(value= "/buscaPorCPF")
    public ResponseEntity<ClientDTO> findClientByCPF(@RequestParam String cpf){
        return ResponseEntity.ok(clientService.findClientByCPF(cpf));
    }
}
