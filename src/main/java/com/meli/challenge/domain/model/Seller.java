package com.meli.challenge.domain.model;

public record Seller(
        String id,
        String name,
        String reputation,
        int salesCount,
        String location

) {
}
