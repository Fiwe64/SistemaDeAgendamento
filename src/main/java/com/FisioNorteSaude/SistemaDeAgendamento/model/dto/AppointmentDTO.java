package com.FisioNorteSaude.SistemaDeAgendamento.model.dto;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Appointment;
import com.FisioNorteSaude.SistemaDeAgendamento.model.Client;
import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.HealthInsurance;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class AppointmentDTO implements Serializable {

    private Long id;
    private LocalDateTime dateTime;
    private ClientDTO client;
    private ProfessionalDTO professional;

    private HealthInsurance healthInsurance;
    private PaymentMethod paymentMethod;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.dateTime = appointment.getDateTime();
        this.client = new ClientDTO(appointment.getClient());
        this.professional = new ProfessionalDTO(appointment.getProfessional());
        this.healthInsurance = appointment.getHealthInsurance();
        this.paymentMethod = appointment.getPaymentMethod();
    }
}
