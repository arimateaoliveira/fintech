package com.fintech.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("isPlanoExclusive")
    private Boolean isPlanoExclusive;
    @JsonProperty("saldo")
    private BigDecimal saldo;
    @JsonProperty("numeroConta")
    private String numeroConta;
    @JsonProperty("dataNascimento")
    private LocalDateTime dataNascimento;

}
