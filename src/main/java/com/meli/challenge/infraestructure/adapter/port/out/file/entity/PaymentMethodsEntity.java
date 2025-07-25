package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

import lombok.Builder;

import java.util.List;

@Builder
public record PaymentMethodsEntity(
        List<String> credit,
        List<String> debit,
        List<String> cash

) {
}
