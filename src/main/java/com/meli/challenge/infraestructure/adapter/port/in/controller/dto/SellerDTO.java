package com.meli.challenge.infraestructure.adapter.port.in.controller.dto;

public record SellerDTO(
        String id,
        String name,
        String reputation,
        int salesCount,
        String location

) {
}
