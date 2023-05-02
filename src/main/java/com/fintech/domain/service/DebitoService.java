package com.fintech.domain.service;

import com.fintech.domain.model.Cliente;
import com.fintech.domain.model.TransactionRequest;
import com.fintech.domain.model.TransactionResponse;
import com.fintech.enums.PercentualTaxa;
import com.fintech.enums.ValoresTaxa;
import com.fintech.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DebitoService extends TransactionServiceAbstract{

    @Autowired
    private ClienteRepository clienteRepository;

    public TransactionResponse execute(TransactionRequest transactionRequest){
        BigDecimal valorSaque = new BigDecimal(transactionRequest.getValor());
        Cliente cliente = clienteRepository.getOne(
                Long.valueOf(transactionRequest.getIdCliente()));
        BigDecimal valorTaxaSaque = validarTaxaSaque(valorSaque, cliente.getIsPlanoExclusive());
        cliente.setSaldo(cliente.getSaldo().subtract(valorSaque).subtract(valorTaxaSaque));
        Cliente clienteResponse = clienteRepository.save(cliente);

        return TransactionResponse.builder()
                .dataNascimento(clienteResponse.getDataNascimento())
                .isPlanoExclusive(clienteResponse.getIsPlanoExclusive())
                .nome(clienteResponse.getNome())
                .numeroConta(clienteResponse.getNumeroConta())
                .saldo(clienteResponse.getSaldo())
                .build();
    }

    public BigDecimal validarTaxaSaque(BigDecimal valorSaque, Boolean isExclusive){
        BigDecimal valorTaxa = new BigDecimal(0);
        if(!isExclusive) {
            if (valorSaque.compareTo(ValoresTaxa.MINIMO.getValue()) > 0 &&
                    valorSaque.compareTo(ValoresTaxa.MAXIMO.getValue()) < 0) {
                valorTaxa = valorSaque.multiply(PercentualTaxa.ESPECIAL.getValue()).divide(new BigDecimal(100));
            } else if (valorSaque.compareTo(ValoresTaxa.MAXIMO.getValue()) > 0) {
                valorTaxa = valorSaque.multiply(PercentualTaxa.SIMPLES.getValue()).divide(new BigDecimal(100));
            }
        }
        return valorTaxa;
    }

}
