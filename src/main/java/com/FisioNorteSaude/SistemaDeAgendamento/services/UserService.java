package com.FisioNorteSaude.SistemaDeAgendamento.services;


import com.FisioNorteSaude.SistemaDeAgendamento.entities.User;
import com.FisioNorteSaude.SistemaDeAgendamento.repositories.UserRepository;
import com.FisioNorteSaude.SistemaDeAgendamento.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);

        return obj.orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado com o ID: "+id));
    }

    public User insert(User obj){
        return userRepository.save(obj);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }






}
