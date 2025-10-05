package com.FisioNorteSaude.SistemaDeAgendamento.model;

import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ClientDTO;
import jakarta.persistence.Entity;
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

    public Client(ClientDTO clientDTO){
        super(clientDTO.getName(), clientDTO.getBirth(), clientDTO.getCpf());

        this.phone = clientDTO.getPhone();

    }
}
