package com.meli.challenge.infraestructure.adapter.port.in.controller.mapper;

import com.meli.challenge.domain.model.product.ProductResponse;
import com.meli.challenge.infraestructure.adapter.port.in.controller.dto.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductControllerMapper {

    ProductControllerMapper PRODUCT_CONTROLLER_MAPPER= Mappers.getMapper(ProductControllerMapper.class);

    ProductResponseDTO toProductResponse(ProductResponse productResponse);

}
