package com.prameswaradev.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INSUFFICIENT_STORAGE)
public class ProductSufficientException extends RuntimeException {
    public ProductSufficientException(String message) {
        super(message);
    }
}
