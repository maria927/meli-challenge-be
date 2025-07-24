package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

import lombok.Builder;

@Builder
public record PriceEntity(
        String currency,
        int amount,
        int decimals

) {
}
