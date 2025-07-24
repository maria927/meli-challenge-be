package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

public record ShippingEntity(
        boolean freeShipping,
        String estimatedDelivery

) {
}
