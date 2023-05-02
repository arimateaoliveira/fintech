package com.fintech.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@NoArgsConstructor
public enum TransactionTypeEnum {

    DEBITO("debito"),
    CREDITO("credito");

    private String label;

    public static TransactionTypeEnum getByLabel(String label) {
        for (TransactionTypeEnum e : TransactionTypeEnum.values()) {
            if (e.label.equalsIgnoreCase(label)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Invalid label on TransactionTypeEnum: " + label);
    }

}
