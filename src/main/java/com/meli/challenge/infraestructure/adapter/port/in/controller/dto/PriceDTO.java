package com.meli.challenge.infraestructure.adapter.port.in.controller.dto;

import lombok.Builder;

@Builder
public record PriceDTO(
        String currency,
        int amount,
        int decimals

) {
}
