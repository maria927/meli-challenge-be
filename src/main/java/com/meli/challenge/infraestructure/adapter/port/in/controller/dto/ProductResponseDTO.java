package com.meli.challenge.infraestructure.adapter.port.in.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
@Schema(description = "DTO de respuesta para producto")
public record ProductResponseDTO(

    @Schema(description = "Identificador único del producto", example = "MLA123456")
    String id,

    @Schema(description = "Título del producto", example = "Auriculares Bluetooth Sony WH-1000XM4")
    String title,

    @Schema(description = "Descripción detallada del producto")
    String description,

    @Schema(description = "Información de precio: moneda, valor y original")
    PriceDTO price,

    @Schema(description = "Porcentaje de descuento aplicado", example = "15.0")
    double discount,

    @Schema(description = "Listado de URLs de imágenes del producto")
    List<String> pictures,

    @Schema(description = "Condición del producto (nuevo, usado, reacondicionado)", example = "new")
    String condition,

    @Schema(description = "Cantidad vendida del producto", example = "245")
    int soldQuantity,

    @Schema(description = "Cantidad disponible en inventario", example = "30")
    int stock,

    @Schema(description = "Calificación del producto", example = "4.5")
    double rating,

    @Schema(description = "Cantiad de opiniones del producto", example = "45")
    int reviewCount,

    @Schema(description = "Información de cuotas: cantidad de pagos y monto por pago")
    InstallmentDTO installments,

    @Schema(description = "Métodos de pago habilitados")
    PaymentMethodsDTO paymentMethods,

    @Schema(description = "Información del vendedor: reputación, tienda, etc.")
    SellerDTO seller,

    @Schema(description = "Especificaciones adicionales del producto")
    List<SpecificationDTO> specifications,

    @Schema(description = "Características principales del producto")
    List<String> characteristics,

    @Schema(description = "Información de envío: tipo, costos, regiones disponibles")
    ShippingDTO shipping
) {}

