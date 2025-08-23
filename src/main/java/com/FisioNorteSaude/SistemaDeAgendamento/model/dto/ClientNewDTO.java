package com.FisioNorteSaude.SistemaDeAgendamento.model.dto;

import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.HealthInsurance;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ClientNewDTO {
    private String name;
    private LocalDate birth;
    private Long cpf;
    private String phone;

}
