package com.meli.challenge.domain.model.product;

import lombok.Builder;

@Builder
public record Seller(
        String id,
        String name,
        String reputation,
        int salesCount,
        String location

) {
}
