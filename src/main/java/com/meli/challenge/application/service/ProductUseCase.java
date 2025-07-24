package com.meli.challenge.application.service;

import com.meli.challenge.application.exception.ProductNotFoundException;
import com.meli.challenge.application.port.in.ProductServicePort;
import com.meli.challenge.application.port.out.JsonProductPort;
import com.meli.challenge.domain.model.product.ProductResponse;
import com.meli.challenge.infraestructure.adapter.port.logging.Loggable;
import org.springframework.stereotype.Service;

@Service
public class ProductUseCase implements ProductServicePort {

    private final JsonProductPort productRepository;

    public ProductUseCase(JsonProductPort productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Obtiene el producto por id, o si no lo encuentra lanza una excepción
     * @param id id del producto
     * @return producto mapeado como ProductResponse
     */
    @Override
    @Loggable("Caso de uso de Productos")
    public ProductResponse getProductById(String id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
