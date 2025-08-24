package com.FisioNorteSaude.SistemaDeAgendamento.controllers;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ClientDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping
    public  ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO obj){
        ClientDTO newClient = clientService.insert(obj);



        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newClient.getId()).toUri();

        return ResponseEntity.created(uri).body(newClient);
    }
}
