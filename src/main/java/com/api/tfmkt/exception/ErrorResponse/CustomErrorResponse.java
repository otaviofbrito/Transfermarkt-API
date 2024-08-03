package com.api.tfmkt.exception.ErrorResponse;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class CustomErrorResponse {
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;


    public CustomErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }
}
