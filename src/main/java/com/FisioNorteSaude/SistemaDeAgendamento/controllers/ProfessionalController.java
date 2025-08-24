package com.FisioNorteSaude.SistemaDeAgendamento.controllers;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ProfessionalDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.services.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/professionals")
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @GetMapping
    public ResponseEntity<List<ProfessionalDTO>> findAll(){
        List<ProfessionalDTO  > list = professionalService.findAll();

        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfessionalDTO> findById(@PathVariable Long id){
        ProfessionalDTO obj = professionalService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public  ResponseEntity<ProfessionalDTO> insert(@RequestBody ProfessionalDTO obj){
        ProfessionalDTO newProfessional = professionalService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProfessional.getId()).toUri();
        return ResponseEntity.created(uri).body(newProfessional);
    }

    @DeleteMapping(value = "/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id){
        professionalService.deleteById(id);

        return ResponseEntity.noContent().build();
     }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProfessionalDTO> update(@PathVariable Long id,@RequestBody ProfessionalDTO obj){
        obj = professionalService.update(id,obj);

        return ResponseEntity.ok().body(obj);
     }
}
