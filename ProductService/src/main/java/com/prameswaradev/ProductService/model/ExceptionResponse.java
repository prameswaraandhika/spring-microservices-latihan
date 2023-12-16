package com.prameswaradev.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
