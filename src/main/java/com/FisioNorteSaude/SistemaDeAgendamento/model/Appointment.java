package com.FisioNorteSaude.SistemaDeAgendamento.model;

import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.HealthInsurance;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.PaymentMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_appointments")
public class Appointment {

    private Long id;
    private LocalDateTime dateTime;
    private Client client;
    private Professional professional;

    @Enumerated(EnumType.STRING)
    private HealthInsurance healthInsurance;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

}
