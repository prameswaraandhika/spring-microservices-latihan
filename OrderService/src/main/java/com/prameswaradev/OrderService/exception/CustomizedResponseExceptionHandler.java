package com.prameswaradev.OrderService.exception;

import com.prameswaradev.OrderService.external.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<?> handleProductException(CustomException exception, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.valueOf(exception.getStatus());
        return new ResponseEntity<>(
                new ExceptionResponse(
                        LocalDateTime.now(),
                        exception.getMessage(),
                        request.getDescription(false)
                ), httpStatus);
    }




}
