package com.FisioNorteSaude.SistemaDeAgendamento.services;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Appointment;
import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.AppointmentDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.AppointmentRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.AppointmentRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public List<AppointmentDTO>  findAll (){
        List<Appointment> list = appointmentRepository.findAll();

        return list.stream().map(AppointmentDTO::new).collect(Collectors.toList());
    }


    public AppointmentDTO insert(AppointmentDTO appointmentDTO){
            Appointment appointment = new Appointment(appointmentDTO);
            appointment = appointmentRepository.save(appointment);
            return new AppointmentDTO(appointment);
    }



}
