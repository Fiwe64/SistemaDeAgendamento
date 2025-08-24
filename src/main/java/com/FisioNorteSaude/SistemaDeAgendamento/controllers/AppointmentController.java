package com.FisioNorteSaude.SistemaDeAgendamento.controllers;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.AppointmentDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll(){
        List<AppointmentDTO  > list = appointmentService.findAll();

        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public  ResponseEntity<AppointmentDTO> insert(@RequestBody AppointmentDTO obj){
        AppointmentDTO newAppointment = appointmentService.insert(obj);



        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAppointment.getId()).toUri();

        return ResponseEntity.created(uri).body(newAppointment);
    }
}
