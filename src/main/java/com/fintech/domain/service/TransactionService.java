package com.fintech.domain.service;

import com.fintech.domain.factory.FintechFactory;
import com.fintech.domain.model.Cliente;
import com.fintech.domain.model.TransactionRequest;
import com.fintech.domain.model.TransactionResponse;
import com.fintech.enums.TransactionTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private FintechFactory fintechFactory;

    public TransactionResponse execute(TransactionRequest transactionRequest) throws Exception {
        return this.fintechFactory.getTransactionService(
                TransactionTypeEnum.getByLabel(transactionRequest.getTipo()))
                .execute(transactionRequest);
    }

}
