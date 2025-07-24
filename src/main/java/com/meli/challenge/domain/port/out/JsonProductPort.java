package com.meli.challenge.domain.port.out;

import com.meli.challenge.domain.model.ProductResponse;

import java.util.Optional;

public interface JsonProductPort {

    Optional<ProductResponse> findProductById(String id);
}
