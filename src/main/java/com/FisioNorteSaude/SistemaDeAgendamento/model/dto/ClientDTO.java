package com.FisioNorteSaude.SistemaDeAgendamento.model.dto;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Client;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.HealthInsurance;
import com.FisioNorteSaude.SistemaDeAgendamento.model.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ClientDTO implements Serializable {


    private Long id;
    private String name;
    private LocalDate birth;
    private Long cpf;
    private String phone;


    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.birth = entity.getBirth();
        this.cpf = entity.getCpf();
        this.phone = entity.getPhone();

    }
    public ClientDTO(ClientDTO entity) {
        this.name = entity.getName();
        this.birth = entity.getBirth();
        this.cpf = entity.getCpf();
        this.phone = entity.getPhone();

    }

}
