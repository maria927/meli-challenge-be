package com.meli.challenge.infraestructure.adapter.port.in.controller.dto;

import lombok.Builder;

@Builder
public record InstallmentDTO(
        int count,
        double amount,
        String currency,
        boolean interestFree

) {
}
