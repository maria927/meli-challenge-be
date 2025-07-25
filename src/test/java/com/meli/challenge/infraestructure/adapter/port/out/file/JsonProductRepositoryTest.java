package com.meli.challenge.infraestructure.adapter.port.out.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.challenge.domain.model.product.ProductResponse;
import com.meli.challenge.infraestructure.adapter.port.out.file.entity.ProductEntity;
import com.meli.challenge.mocks.ProductMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class JsonProductRepositoryTest {

    private ObjectMapper objectMapper;
    private JsonProductRepository repository;

    @BeforeEach
    void setUp() throws IllegalAccessException {
        objectMapper = mock(ObjectMapper.class);
        repository = new JsonProductRepository(objectMapper);
        ProductEntity mockEntity = ProductMock.buildMotorolaEdge50Pro();
        Map<String, ProductEntity> mockStore = Map.of("MLA987654", mockEntity);
        var storeField = JsonProductRepository.class.getDeclaredFields()[1];
        storeField.setAccessible(true);
        storeField.set(repository, mockStore);
    }

    @Test
    void shouldReturnProductResponseWhenIdExists() {
        Optional<ProductResponse> result = repository.findProductById("MLA987654");

        assertTrue(result.isPresent());
        assertEquals("MLA987654", result.get().id());
        assertEquals("Celular Motorola", result.get().description());
    }

    @Test
    void shouldReturnEmptyWhenIdNotFound() {
        Optional<ProductResponse> result = repository.findProductById("999");

        assertFalse(result.isPresent());
    }

}