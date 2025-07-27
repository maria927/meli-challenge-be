package com.meli.challenge.domain.model.product;

import lombok.Builder;

@Builder
public record Specification(
        String label,
        String value

) {
}
