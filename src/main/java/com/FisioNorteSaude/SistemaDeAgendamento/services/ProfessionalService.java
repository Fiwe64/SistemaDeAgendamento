package com.FisioNorteSaude.SistemaDeAgendamento.services;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ProfessionalDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.ProfessionalRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;


    public List<ProfessionalDTO>  findAll (){
        List<Professional> list = professionalRepository.findAll();
        return list.stream().map(ProfessionalDTO::new).collect(Collectors.toList());
    }

    public ProfessionalDTO findByCpf(Long cpf){
        Optional<Professional> professional = professionalRepository.findByCpf(cpf);

        Professional entity = professional.orElseThrow(()-> new ResourceNotFoundException("Professionale com CPF " + cpf + " não encontrado."));

        return new ProfessionalDTO(entity);
    }

    public ProfessionalDTO findById(Long id){
        Optional<Professional> professional = professionalRepository.findById(id);

        Professional entity = professional.orElseThrow(()-> new ResourceNotFoundException("Professionale com id " + id + " não encontrado."));

        return new ProfessionalDTO(entity);
    }

    public ProfessionalDTO insert(ProfessionalDTO professionalDTO){
            Professional professional = new Professional(professionalDTO);

            professional = professionalRepository.save(professional);


            return new ProfessionalDTO(professional);
    }

    public void deleteById(Long id){
        professionalRepository.deleteById(id);
    }

    public ProfessionalDTO update(Long id, ProfessionalDTO professionalDTO){
            Professional entity = professionalRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Professionale com ID " + id + " não encontrado."));

            updateData(entity,professionalDTO);

            entity = professionalRepository.save(entity);

            return new ProfessionalDTO(entity);
    }

    private void updateData(Professional entity, ProfessionalDTO dto) {
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getCpf() != null) {
            entity.setCpf(dto.getCpf());
        }

        if (dto.getBirth() != null) {
            entity.setBirth(dto.getBirth());
        }
        if(dto.getSpecialty() != null){
            entity.setSpecialty(dto.getSpecialty());
        }
    }





}
