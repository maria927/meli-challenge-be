package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

import lombok.Builder;

import java.util.List;

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
        List<SpecificationEntity> specifications,
        List<String> characteristics,
        ShippingEntity shipping
) {}

