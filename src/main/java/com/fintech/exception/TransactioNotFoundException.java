package com.fintech.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactioNotFoundException extends RuntimeException{
    public TransactioNotFoundException(String message){
        super(message);
    }
}
