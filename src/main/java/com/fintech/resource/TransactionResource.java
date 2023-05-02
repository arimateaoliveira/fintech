package com.fintech.resource;

import com.fintech.domain.model.Cliente;
import com.fintech.domain.model.TransactionRequest;
import com.fintech.domain.model.TransactionResponse;
import com.fintech.domain.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fintech")
public class TransactionResource {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public TransactionResponse transaction(@RequestBody TransactionRequest transactionRequest) throws Exception {
        return transactionService.execute(transactionRequest);
    }

}
