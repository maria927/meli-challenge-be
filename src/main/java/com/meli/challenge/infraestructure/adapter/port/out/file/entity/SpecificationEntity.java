package com.meli.challenge.infraestructure.adapter.port.out.file.entity;

import lombok.Builder;

@Builder
public record SpecificationEntity(
        String label,
        String value

) {
}
