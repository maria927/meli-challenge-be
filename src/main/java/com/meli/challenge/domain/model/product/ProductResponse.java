package com.meli.challenge.domain.model.product;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record ProductResponse(
        String id,
        String title,
        String description,
        Price price,
        double discount,
        List<String> pictures,
        String condition,
        int soldQuantity,
        int stock,
        Installment installments,
        PaymentMethods paymentMethods,
        Seller seller,
        Map<String, Object> characteristics,
        Shipping shipping
) {}

