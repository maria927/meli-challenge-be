package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

import lombok.Builder;

@Builder
public record SellerEntity(
        String id,
        String name,
        String reputation,
        int salesCount,
        String location

) {
}
