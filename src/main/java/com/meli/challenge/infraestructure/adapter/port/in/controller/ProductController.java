package com.meli.challenge.infraestructure.adapter.port.in.controller;

import com.meli.challenge.domain.port.in.ProductServicePort;
import com.meli.challenge.infraestructure.adapter.port.in.controller.dto.ProductResponseDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.meli.challenge.infraestructure.adapter.port.in.controller.mapper.ProductControllerMapper.PRODUCT_CONTROLLER_MAPPER;

//@Tag(name = "Products", description = "Operaciones sobre productos")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductServicePort service;

    public ProductController(ProductServicePort service) {
        this.service = service;
    }

//    @Operation(
//            summary = "Obtiene los detalles de un producto por su ID",
//            description = "Devuelve un DTO del producto si existe, o lanza una excepción controlada",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Producto encontrado"),
//                    @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
//                    @ApiResponse(responseCode = "500", description = "Error de servidor")
//            }
//    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable @NotBlank String id) {
        return ResponseEntity.ok(
                PRODUCT_CONTROLLER_MAPPER.toProductResponse(service.getProductById(id)));
    }
}
