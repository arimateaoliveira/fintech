package com.fintech.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRequest {

    private String idCliente;
    private String valor;
    private String tipo;

}
