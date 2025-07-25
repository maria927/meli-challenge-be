package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

import lombok.Builder;

@Builder
public record InstallmentEntity(
        int count,
        double amount,
        String currency,
        boolean interestFree

) {
}
