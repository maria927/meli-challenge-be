package com.meli.challenge.domain.model;

import lombok.Builder;


@Builder
public record Price(
        String currency,
        int amount,
        int decimals

) {
}
