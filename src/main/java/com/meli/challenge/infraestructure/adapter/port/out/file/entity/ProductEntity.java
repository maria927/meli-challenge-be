package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record ProductEntity(
        String id,
        String title,
        String description,
        PriceEntity price,
        double discount,
        List<String> pictures,
        String condition,
        int soldQuantity,
        int stock,
        InstallmentEntity installments,
        PaymentMethodsEntity paymentMethods,
        SellerEntity seller,
        Map<String, Object> characteristics,
        ShippingEntity shipping
) {}

