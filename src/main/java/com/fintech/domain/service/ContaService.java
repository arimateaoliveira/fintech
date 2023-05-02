package com.fintech.domain.service;

import com.fintech.domain.model.Cliente;
import com.fintech.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContaService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void update(Long clienteId, Cliente cliente){
        cliente.setId(clienteId);
        clienteRepository.save(cliente);
    }

    public void delete(Long clienteId){
        Cliente cliente = Cliente.builder().id(clienteId).build();
        clienteRepository.delete(cliente);
    }

    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

}
