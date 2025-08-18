package com.FisioNorteSaude.SistemaDeAgendamento.entities;

import com.FisioNorteSaude.SistemaDeAgendamento.entities.enums.Specialty;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_professionals")
public class Professional extends User{

    @Enumerated(EnumType.STRING)
    private Specialty specialty;
}
