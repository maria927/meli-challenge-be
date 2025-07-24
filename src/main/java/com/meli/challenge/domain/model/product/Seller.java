package com.meli.challenge.domain.model.product;

public record Seller(
        String id,
        String name,
        String reputation,
        int salesCount,
        String location

) {
}
