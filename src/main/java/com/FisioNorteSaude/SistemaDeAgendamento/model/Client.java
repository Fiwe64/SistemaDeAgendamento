package com.FisioNorteSaude.SistemaDeAgendamento.model;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ClientNewDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.HealthInsurance;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.PaymentMethod;
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
@Table(name = "tb_clients")
public class Client extends User{

    private String phone;

    @Enumerated(EnumType.STRING)
    HealthInsurance healthInsurance;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;


    public Client(ClientNewDTO clientDTO){
        super();
        this.name = clientDTO.getName();
        this.cpf = clientDTO.getCpf();
        this.birth = clientDTO.getBirth();

        this.phone = clientDTO.getPhone();
        this.healthInsurance = clientDTO.getHealthInsurance();
        this.paymentMethod = clientDTO.getPaymentMethod();
    }
}
