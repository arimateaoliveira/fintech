package com.fintech.resource;


import com.fintech.domain.model.Cliente;
import com.fintech.domain.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fintech/cliente")
public class ClienteResource {

    @Autowired
    private ContaService contaService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {
        Cliente clienteDb = contaService.save(cliente);
        return cliente;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> update(@PathVariable( "id" ) Long clienteId, @RequestBody Cliente cliente) {
        contaService.update(clienteId, cliente);
        return ResponseEntity.ok("Cliente alterado com sucesso.");
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        contaService.delete(id);
        return ResponseEntity.ok("Cliente apagado com sucesso.");
    }

    @GetMapping("/getAllClientes")
    public List<Cliente> getAllClientes() {
        List<Cliente> clienteList = contaService.getAllClientes();
        return clienteList;
    }

}
