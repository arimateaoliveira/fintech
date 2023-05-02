package com.fintech.domain.service;

import com.fintech.domain.model.Cliente;
import com.fintech.domain.model.TransactionRequest;
import com.fintech.domain.model.TransactionResponse;
import com.fintech.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditoService extends TransactionServiceAbstract{

    @Autowired
    private ClienteRepository clienteRepository;

    public TransactionResponse execute(TransactionRequest transactionRequest){
        Cliente cliente = clienteRepository
                .getOne(Long.valueOf(transactionRequest.getIdCliente()));
        cliente.setSaldo(cliente.getSaldo().add(new BigDecimal(transactionRequest.getValor())));
        Cliente clienteBd = clienteRepository.save(cliente);
        return TransactionResponse.builder()
                .dataNascimento(clienteBd.getDataNascimento())
                .isPlanoExclusive(clienteBd.getIsPlanoExclusive())
                .nome(clienteBd.getNome())
                .numeroConta(clienteBd.getNumeroConta())
                .saldo(clienteBd.getSaldo())
                .build();
    }

}
