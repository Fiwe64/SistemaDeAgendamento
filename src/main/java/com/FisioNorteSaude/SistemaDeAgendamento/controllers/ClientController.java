package com.FisioNorteSaude.SistemaDeAgendamento.controllers;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Client;
import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ClientDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.ClientRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<ClientDTO  > list = clientService.findAll();

        return ResponseEntity.ok().body(list);
    }
}
