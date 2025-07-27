package com.meli.challenge.infraestructure.adapter.port.in.controller.dto;

import lombok.Builder;

@Builder
public record SpecificationDTO(
        String label,
        String value

) {
}
