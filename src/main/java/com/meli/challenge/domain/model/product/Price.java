package com.meli.challenge.domain.model.product;

import lombok.Builder;


@Builder
public record Price(
        String currency,
        int amount,
        int decimals

) {
}
