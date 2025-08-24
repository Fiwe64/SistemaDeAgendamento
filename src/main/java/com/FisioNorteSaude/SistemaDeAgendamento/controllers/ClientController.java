package com.FisioNorteSaude.SistemaDeAgendamento.controllers;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Client;
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
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO obj = clientService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public  ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO obj){
        ClientDTO newClient = clientService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newClient.getId()).toUri();
        return ResponseEntity.created(uri).body(newClient);
    }

    @DeleteMapping(value = "/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.deleteById(id);

        return ResponseEntity.noContent().build();
     }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id,@RequestBody ClientDTO obj){
        obj = clientService.update(id,obj);

        return ResponseEntity.ok().body(obj);
     }
}
