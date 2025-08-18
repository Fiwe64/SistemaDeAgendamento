package com.FisioNorteSaude.SistemaDeAgendamento.entities;

import com.FisioNorteSaude.SistemaDeAgendamento.entities.enums.HealthInsurance;
import com.FisioNorteSaude.SistemaDeAgendamento.entities.enums.PaymentMethod;
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
@Table(name = "tb_clients")
public class Client extends User{

    @Enumerated(EnumType.STRING)
    HealthInsurance healthInsurance;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;
}
