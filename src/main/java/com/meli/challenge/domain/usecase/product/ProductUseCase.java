package com.meli.challenge.domain.usecase.product;

import com.meli.challenge.domain.model.ProductResponse;
import com.meli.challenge.domain.port.in.ProductServicePort;
import com.meli.challenge.domain.port.out.JsonProductPort;
import com.meli.challenge.domain.usecase.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductUseCase implements ProductServicePort {

    private final JsonProductPort productRepository;

    public ProductUseCase(JsonProductPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse getProductById(String id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
