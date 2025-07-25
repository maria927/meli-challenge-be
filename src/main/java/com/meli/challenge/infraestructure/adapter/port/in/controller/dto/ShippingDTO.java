package com.meli.challenge.infraestructure.adapter.port.in.controller.dto;

public record ShippingDTO(
        boolean freeShipping,
        String estimatedDelivery

) {
}
