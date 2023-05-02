package com.fintech.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum PercentualTaxa {
    
    ISENTO(new BigDecimal("0.00")),
    ESPECIAL(new BigDecimal("0.40")),
    SIMPLES(new BigDecimal("1.00"));

    public final BigDecimal value;

}
