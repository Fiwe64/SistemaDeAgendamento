package com.FisioNorteSaude.SistemaDeAgendamento.model;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ProfessionalDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.Specialty;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_professionals")
public class Professional extends User{

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    public Professional(ProfessionalDTO entity) {
        super.setName(entity.getName());
        super.setCpf(entity.getCpf());
        super.setBirth(entity.getBirth());

        this.specialty = entity.getSpecialty();
    }
}
