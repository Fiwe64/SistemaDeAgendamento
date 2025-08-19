package com.FisioNorteSaude.SistemaDeAgendamento.services;

import com.FisioNorteSaude.SistemaDeAgendamento.entities.Client;
import com.FisioNorteSaude.SistemaDeAgendamento.entities.dto.ClientDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.entities.dto.ClientNewDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.ClientRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientDTO>  findAll (){
        List<Client> list = clientRepository.findAll();

        return list.stream().map(ClientDTO::new).collect(Collectors.toList());
    }
    public ClientDTO findByCpf(Long cpf){
        Optional<Client> client = clientRepository.findByCpf(cpf);

        Client entity = client.orElseThrow(()-> new ResourceNotFoundException("Cliente com CPF " + cpf + " não encontrado."));

        return new ClientDTO(entity);
    }


}
