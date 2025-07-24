package com.meli.challenge.application.port.out;

import com.meli.challenge.domain.model.product.ProductResponse;

import java.util.Optional;

public interface JsonProductPort {

    Optional<ProductResponse> findProductById(String id);
}
