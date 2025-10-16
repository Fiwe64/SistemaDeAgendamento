package com.FisioNorteSaude.SistemaDeAgendamento.services;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Appointment;
import com.FisioNorteSaude.SistemaDeAgendamento.model.Client;
import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.AppointmentDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.AppointmentNewDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.WorkShift;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.AppointmentRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.ClientRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.ProfessionalRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.services.exceptions.BusinnesException;
import com.FisioNorteSaude.SistemaDeAgendamento.services.exceptions.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProfessionalRepository professionalRepository;



    public List<AppointmentDTO> findAll() {
        List<Appointment> list = appointmentRepository.findAll();return list.stream().map(AppointmentDTO::new).collect(Collectors.toList());
    }

    public List<AppointmentDTO> findDisponiveis(){
        List<Appointment> todos = appointmentRepository.findAll();

        List<Appointment> disponiveis= new ArrayList<>();

        for(Appointment obj : todos){
            if(!obj.isFinalizado()){
                disponiveis.add(obj);
            }
        }

        return disponiveis.stream()
                .map(AppointmentDTO::new)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public AppointmentDTO findById(Long id) {
        Appointment entity = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento com id " + id + " não encontrado."));
        return new AppointmentDTO(entity);
    }


    @Transactional
    public AppointmentDTO insert(AppointmentNewDTO dto) { //usando um DTO de entrada

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + dto.getClientId()));
        Professional professional = professionalRepository.findById(dto.getProfessionalId())
                .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado com o ID: " + dto.getProfessionalId()));


        Appointment entity = new Appointment();
        entity.setDateTime(dto.getDateTime());
        entity.setClient(client);
        entity.setProfessional(professional);
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setHealthInsurance(dto.getHealthInsurance());

        // 3. Salva e retorna o DTO de saída
        entity = appointmentRepository.save(entity);
        return new AppointmentDTO(entity);
    }


    public void deleteById(Long id){
        appointmentRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public AppointmentDTO update(Long id, AppointmentNewDTO dto) { // Recebe o DTO de entrada
        Appointment entity = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento com ID " + id + " não encontrado."));

        updateData(entity, dto);

        entity = appointmentRepository.save(entity);
        return new AppointmentDTO(entity);
    }






    private void updateData(Appointment entity, AppointmentNewDTO dto) { // Usa o DTO de entrada
        if (dto.getProfessionalId() != null) {
            Professional professional = professionalRepository.findById(dto.getProfessionalId())
                    .orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado com o ID: " + dto.getProfessionalId()));
            entity.setProfessional(professional);
        }
        if (dto.getClientId() != null) {
            Client client = clientRepository.findById(dto.getClientId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + dto.getClientId()));
            entity.setClient(client);
        }
        if (dto.getHealthInsurance() != null) {
            entity.setHealthInsurance(dto.getHealthInsurance());
        }
        if (dto.getPaymentMethod() != null) {
            entity.setPaymentMethod(dto.getPaymentMethod());
        }
        if (dto.getDateTime() != null) {
            entity.setDateTime(dto.getDateTime());
        }
    }





}
