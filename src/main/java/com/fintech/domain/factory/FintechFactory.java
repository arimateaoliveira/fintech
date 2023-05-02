package com.fintech.domain.factory;

import com.fintech.domain.service.CreditoService;
import com.fintech.domain.service.DebitoService;
import com.fintech.domain.service.TransactionServiceAbstract;
import com.fintech.enums.TransactionTypeEnum;
import com.fintech.exception.TransactioNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FintechFactory {

    private final DebitoService debitoService;
    private final CreditoService creditoService;
    private EnumMap<TransactionTypeEnum, TransactionServiceAbstract> transactionServiceAbstract;

    @PostConstruct
    public void init() {
        this.transactionServiceAbstract = new EnumMap<>(TransactionTypeEnum.class);
        this.transactionServiceAbstract.put(TransactionTypeEnum.DEBITO, debitoService);
        this.transactionServiceAbstract.put(TransactionTypeEnum.CREDITO, creditoService);
    }

    public TransactionServiceAbstract getTransactionService(@NonNull TransactionTypeEnum storesEnum) {
        return Optional.ofNullable(this.transactionServiceAbstract.get(storesEnum))
                .orElseThrow(TransactioNotFoundException::new);
    }

}
