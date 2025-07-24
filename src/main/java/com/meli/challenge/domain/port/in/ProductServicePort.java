package com.meli.challenge.domain.port.in;

import com.meli.challenge.domain.model.ProductResponse;

public interface ProductServicePort {

    ProductResponse getProductById(String id);
}
