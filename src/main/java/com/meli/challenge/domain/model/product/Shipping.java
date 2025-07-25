package com.meli.challenge.domain.model.product;

import lombok.Builder;

@Builder
public record Shipping(
        boolean freeShipping,
        String estimatedDelivery

) {
}
