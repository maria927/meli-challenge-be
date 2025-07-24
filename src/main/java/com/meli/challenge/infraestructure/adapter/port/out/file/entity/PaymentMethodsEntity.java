package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

import java.util.List;

public record PaymentMethodsEntity(
        List<String> credit,
        List<String> debit,
        List<String> cash

) {
}
