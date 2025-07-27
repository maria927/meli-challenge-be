package com.meli.challenge.infraestructure.adapter.port.in.controller;

import com.meli.challenge.application.port.in.ProductServicePort;
import com.meli.challenge.infraestructure.adapter.port.in.controller.dto.ProductResponseDTO;
import com.meli.challenge.infraestructure.adapter.port.logging.Loggable;
import com.meli.challenge.infraestructure.adapter.port.shared.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.meli.challenge.infraestructure.adapter.port.in.controller.mapper.ProductControllerMapper.PRODUCT_CONTROLLER_MAPPER;

@Tag(name = "Products", description = "Operaciones sobre productos")
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductServicePort service;

    public ProductController(ProductServicePort service) {
        this.service = service;
    }

    @Operation(
            summary = "Obtiene los detalles de un producto por su ID",
            description = "Devuelve un producto si este existe, o por lo contrario, lanza una excepción controlada",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto encontrado"),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error general",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Loggable("Controlador")
    public ResponseEntity<ProductResponseDTO> getProductById(
            @Parameter(description = "Id del producto a buscar", example = "ML1")
            @PathVariable @NotBlank String id) {
        return ResponseEntity.ok(
                PRODUCT_CONTROLLER_MAPPER.toProductResponse(service.getProductById(id)));
    }
}
