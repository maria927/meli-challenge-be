package com.meli.challenge.domain.model.product;

import java.util.List;

public record PaymentMethods(
        List<String> credit,
        List<String> debit,
        List<String> cash

) {
}
