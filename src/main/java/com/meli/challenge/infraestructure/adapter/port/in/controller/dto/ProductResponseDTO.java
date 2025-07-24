package com.meli.challenge.infraestructure.adapter.port.in.controller.dto;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record ProductResponseDTO(
        String id,
        String title,
        String description,
        PriceDTO price,
        double discount,
        List<String> pictures,
        String condition,
        int soldQuantity,
        int stock,
        InstallmentDTO installments,
        PaymentMethodsDTO paymentMethods,
        SellerDTO seller,
        Map<String, Object> characteristics,
        ShippingDTO shipping
) {}

