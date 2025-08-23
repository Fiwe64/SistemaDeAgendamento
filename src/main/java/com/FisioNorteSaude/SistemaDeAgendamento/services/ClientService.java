package com.FisioNorteSaude.SistemaDeAgendamento.services;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Client;
import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ClientDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ClientNewDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.ClientRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public List<ClientDTO>  findAll (){
        List<Client> list = clientRepository.findAll();

        return list.stream().map(ClientDTO::new).collect(Collectors.toList());
    }


    public ClientDTO findByCpf(Long cpf){
        Optional<Client> client = clientRepository.findByCpf(cpf);

        Client entity = client.orElseThrow(()-> new ResourceNotFoundException("Cliente com CPF " + cpf + " não encontrado."));

        return new ClientDTO(entity);
    }

    public ClientDTO insert(ClientNewDTO clientDTO){
            Client client = new Client(clientDTO);

            client = clientRepository.save(client);


            return new ClientDTO(client);
    }





}
