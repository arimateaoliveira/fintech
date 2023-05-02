package com.fintech.domain.service;

import com.fintech.domain.model.TransactionRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

//@SpringBootTest
public class DebitoServiceTest {

    //@Autowired
    DebitoService debitoService;

    //@Test
    void whenSaqueIsIsento(){

        TransactionRequest transactionRequest = TransactionRequest.builder()
                .idCliente("1")
                .tipo("debito")
                .valor("99")
                .build();

        debitoService.execute(transactionRequest);

    }

}