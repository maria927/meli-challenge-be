package com.meli.challenge.domain.model;

import lombok.Builder;

@Builder
public record Installment(
        int count,
        double amount,
        String currency,
        boolean interestFree

) {
}
