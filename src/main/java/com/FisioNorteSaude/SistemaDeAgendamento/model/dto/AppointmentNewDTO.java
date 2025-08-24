package com.FisioNorteSaude.SistemaDeAgendamento.model.dto;

import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.HealthInsurance;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AppointmentNewDTO implements Serializable {
    private LocalDateTime dateTime;
    private Long clientId;
    private Long professionalId;
    private HealthInsurance healthInsurance;
    private PaymentMethod paymentMethod;
}
