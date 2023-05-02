package com.fintech.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
