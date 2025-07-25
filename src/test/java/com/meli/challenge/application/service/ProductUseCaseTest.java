package com.meli.challenge.application.service;

import com.meli.challenge.application.exception.ProductNotFoundException;
import com.meli.challenge.application.port.out.JsonProductPort;
import com.meli.challenge.domain.model.product.ProductResponse;
import com.meli.challenge.mocks.ProductMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductUseCaseTest {

    private JsonProductPort productRepository;
    private ProductUseCase productUseCase;

    @BeforeEach
    void setUp() {
        productRepository = mock(JsonProductPort.class);
        productUseCase = new ProductUseCase(productRepository);
    }

    @Test
    void getProductByIdWhenProductExists() {

        String productId = "MLA172839";
        ProductResponse expectedProduct = ProductMock.buildSamsungGalaxyA55();
        when(productRepository.findProductById(productId)).thenReturn(Optional.of(expectedProduct));


        ProductResponse actualProduct = productUseCase.getProductById(productId);


        assertNotNull(actualProduct);
        assertEquals(expectedProduct.id(), actualProduct.id());
        assertEquals(expectedProduct.description(), actualProduct.description());
        assertEquals(expectedProduct.price().amount(), actualProduct.price().amount());
        verify(productRepository, times(1)).findProductById(productId);
    }

    @Test
    void throwExceptionWhenProductDoesNotExist() {

        String productId = "123";
        when(productRepository.findProductById(productId)).thenReturn(Optional.empty());


        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class,
                () -> productUseCase.getProductById(productId));

        assertEquals("Product not found: "+productId, exception.getMessage());
        verify(productRepository, times(1)).findProductById(productId);
    }

}