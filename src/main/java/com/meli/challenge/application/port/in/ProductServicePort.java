package com.meli.challenge.application.port.in;

import com.meli.challenge.domain.model.product.ProductResponse;

public interface ProductServicePort {

    ProductResponse getProductById(String id);
}
