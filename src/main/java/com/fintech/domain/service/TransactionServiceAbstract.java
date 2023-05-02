package com.fintech.domain.service;

import com.fintech.domain.model.Cliente;
import com.fintech.domain.model.TransactionRequest;
import com.fintech.domain.model.TransactionResponse;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
public abstract class TransactionServiceAbstract {

    public TransactionResponse execute(@NonNull TransactionRequest transactionRequest) throws Exception {
        throw new Exception();
    }

}
