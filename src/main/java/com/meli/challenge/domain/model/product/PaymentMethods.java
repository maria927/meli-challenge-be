package com.meli.challenge.domain.model.product;

import lombok.Builder;

import java.util.List;

@Builder
public record PaymentMethods(
        List<String> credit,
        List<String> debit,
        List<String> cash

) {
}
