package com.prameswaradev.OrderService.external.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
