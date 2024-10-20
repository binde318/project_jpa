package com.binde.Multilent.suppliers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNoTFoundException extends RuntimeException {
    public ResourceNoTFoundException(String message) {
        super(message);
    }
}
