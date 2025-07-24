package com.meli.challenge.infraestructure.adapter.port.shared.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private String timestamp;

    public ErrorResponse(String message) {
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

}
