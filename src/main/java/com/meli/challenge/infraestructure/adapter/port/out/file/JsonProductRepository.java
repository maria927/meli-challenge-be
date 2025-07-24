package com.meli.challenge.infraestructure.adapter.port.out.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.challenge.domain.model.ProductResponse;
import com.meli.challenge.domain.port.out.JsonProductPort;
import com.meli.challenge.infraestructure.adapter.port.out.file.entity.ProductEntity;
import com.meli.challenge.infraestructure.adapter.port.shared.exception.ReadFileException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.meli.challenge.infraestructure.adapter.port.out.file.mapper.ProductRepositoryMapper.PRODUCT_REPOSITORY_MAPPER;

@Repository
public class JsonProductRepository implements JsonProductPort {

    private final ObjectMapper objectMapper;
    private Map<String, ProductEntity> store = new HashMap<>();

    public JsonProductRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    void init() {
        try (InputStream is = getClass().getResourceAsStream("/files/products.json")) {
            store = objectMapper
                    .readValue(is, new TypeReference<List<ProductEntity>>(){})
                    .stream()
                    .collect(Collectors.toMap(ProductEntity::id, Function.identity()));
        } catch (IOException e) {
            throw new ReadFileException(e);
        }

    }

    @Override
    public Optional<ProductResponse> findProductById(String id) {
        return Optional.ofNullable(PRODUCT_REPOSITORY_MAPPER.productEntityToDomain(store.get(id)));
    }
}
