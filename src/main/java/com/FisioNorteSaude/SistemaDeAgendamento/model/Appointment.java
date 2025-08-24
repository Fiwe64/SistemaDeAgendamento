package com.FisioNorteSaude.SistemaDeAgendamento.model;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.AppointmentDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.HealthInsurance;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;

    @Enumerated(EnumType.STRING)
    private HealthInsurance healthInsurance;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;


    public Appointment(AppointmentDTO entity){
        this.id = entity.getId();
        this.dateTime = entity.getDateTime();
        this.client = new Client(entity.getClient());
        this.professional = new Professional(entity.getProfessional());
        this.healthInsurance = entity.getHealthInsurance();
        this.paymentMethod = entity.getPaymentMethod();
    }
}
