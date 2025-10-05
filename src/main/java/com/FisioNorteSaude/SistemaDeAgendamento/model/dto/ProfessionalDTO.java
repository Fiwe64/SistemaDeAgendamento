package com.FisioNorteSaude.SistemaDeAgendamento.model.dto;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.Specialty;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.WorkShift;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class ProfessionalDTO implements Serializable {

    private Long id;
    private String name;
    private LocalDate birth;
    private String cpf;
    private Specialty specialty;
    private Set<WorkShift> workShift;



    public ProfessionalDTO(Professional entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.birth = entity.getBirth();
        this.cpf = entity.getCpf();
        this.specialty = entity.getSpecialty();
    }
}
