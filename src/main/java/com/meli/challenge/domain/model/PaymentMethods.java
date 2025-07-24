package com.meli.challenge.domain.model;

import java.util.List;

public record PaymentMethods(
        List<String> credit,
        List<String> debit,
        List<String> cash

) {
}
