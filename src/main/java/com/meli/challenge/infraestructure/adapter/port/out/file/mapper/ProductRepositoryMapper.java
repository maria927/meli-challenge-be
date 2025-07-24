package com.meli.challenge.infraestructure.adapter.port.out.file.mapper;

import com.meli.challenge.domain.model.ProductResponse;
import com.meli.challenge.infraestructure.adapter.port.out.file.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductRepositoryMapper {
    ProductRepositoryMapper PRODUCT_REPOSITORY_MAPPER= Mappers.getMapper(ProductRepositoryMapper.class);

    ProductResponse productEntityToDomain(ProductEntity product);
}
