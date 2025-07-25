package com.meli.challenge.infraestructure.adapter.port.shared.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ErrorResponse", description = "Detalles del error")
public record ErrorResponse(
        @Schema(description = "Mensaje del error")
        String message,
        @Schema(description = "Fecha y hora del error")
        String timestamp) {}
