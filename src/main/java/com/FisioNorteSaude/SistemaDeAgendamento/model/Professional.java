package com.FisioNorteSaude.SistemaDeAgendamento.model;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ProfessionalDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.Specialty;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.WorkShift;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_professionals")
public class Professional extends User{

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @ElementCollection(targetClass = WorkShift.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_professional_work_shifts", joinColumns = @JoinColumn(name = "professional_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "work_shift", nullable = false)
    private Set<WorkShift> workShifts;

    public Professional(ProfessionalDTO entity) {
        super(entity.getName(), entity.getBirth(), entity.getCpf());

        this.specialty = entity.getSpecialty();
        this.workShifts = entity.getWorkShift();
    }
}
