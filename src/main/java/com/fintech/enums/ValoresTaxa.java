package com.fintech.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ValoresTaxa {
    
    MINIMO(new BigDecimal("100.00")),
    MAXIMO(new BigDecimal("300.00"));

    public final BigDecimal value;

}
