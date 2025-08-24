package com.FisioNorteSaude.SistemaDeAgendamento.services;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Client;
import com.FisioNorteSaude.SistemaDeAgendamento.model.dto.ClientDTO;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.ClientRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.services.exceptions.ResourceNotFoundException;
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

    public ClientDTO findById(Long id){
        Optional<Client> client = clientRepository.findByCpf(id);

        Client entity = client.orElseThrow(()-> new ResourceNotFoundException("Cliente com CPF " + id + " não encontrado."));

        return new ClientDTO(entity);
    }

    public ClientDTO insert(ClientDTO clientDTO){
            Client client = new Client(clientDTO);

            client = clientRepository.save(client);


            return new ClientDTO(client);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

    public ClientDTO update(Long id, ClientDTO clientDTO){
            Client entity = clientRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + id + " não encontrado."));

            updateData(entity,clientDTO);

            entity = clientRepository.save(entity);

            return new ClientDTO(entity);
    }

    private void updateData(Client entity,ClientDTO dto){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setPhone(dto.getPhone());
        entity.setBirth(dto.getBirth());
    }





}
