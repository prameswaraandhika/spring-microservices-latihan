package com.prameswaradev.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INSUFFICIENT_STORAGE)
public class InsufficientProducts extends RuntimeException {
    public InsufficientProducts(String message) {
        super(message);
    }
}
