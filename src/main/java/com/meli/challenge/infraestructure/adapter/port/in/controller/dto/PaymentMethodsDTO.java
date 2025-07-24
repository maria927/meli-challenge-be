package com.meli.challenge.infraestructure.adapter.port.in.controller.dto;

import java.util.List;

public record PaymentMethodsDTO(
        List<String> credit,
        List<String> debit,
        List<String> cash

) {
}
