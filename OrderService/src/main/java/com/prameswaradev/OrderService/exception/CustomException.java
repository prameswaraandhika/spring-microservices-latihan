package com.prameswaradev.OrderService.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomException extends RuntimeException{
    private int status;

    // Default constructor
    public CustomException() {
        super();
    }

    // Constructor with a message, code, and status
    @JsonCreator
    public CustomException(
            @JsonProperty("message") String message,
            @JsonProperty("status") int status) {
        super(message);
        this.status = status;
    }


}