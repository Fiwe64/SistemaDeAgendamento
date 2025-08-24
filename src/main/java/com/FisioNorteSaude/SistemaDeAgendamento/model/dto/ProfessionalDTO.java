package com.FisioNorteSaude.SistemaDeAgendamento.model.dto;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.Specialty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProfessionalDTO implements Serializable {

    private Long id;
    private String name;
    private LocalDate birth;
    private Long cpf;
    private Specialty specialty;

    public ProfessionalDTO(Professional entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.birth = entity.getBirth();
        this.cpf = entity.getCpf();
        this.specialty = entity.getSpecialty();
    }
}
