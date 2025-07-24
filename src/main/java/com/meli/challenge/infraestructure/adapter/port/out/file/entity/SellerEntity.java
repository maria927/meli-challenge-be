package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

public record SellerEntity(
        String id,
        String name,
        String reputation,
        int salesCount,
        String location

) {
}
