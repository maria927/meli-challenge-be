package com.meli.challenge.mocks;

import com.meli.challenge.domain.model.product.*;
import com.meli.challenge.infraestructure.adapter.port.out.file.entity.*;

import java.util.List;
import java.util.Map;

public class ProductMock {

    public static ProductResponse buildSamsungGalaxyA55() {
        return ProductResponse.builder()
                .id("MLA172839")
                .title("Samsung Galaxy A55 5G Dual SIM 256 GB Azul")
                .description("Pantalla de 6.6, 8 GB de RAM, cámara trasera de 50 Mpx, procesador octa-core y batería de larga duración.")
                .price(Price.builder()
                        .currency("ARS")
                        .amount(439)
                        .decimals(0)
                        .build())
                .discount(0.12)
                .pictures(List.of(
                        "https://mi-cdn.com/images/MLA172839_1.jpg",
                        "https://mi-cdn.com/images/MLA172839_2.jpg",
                        "https://mi-cdn.com/images/MLA172839_3.jpg"))
                .condition("new")
                .soldQuantity(120)
                .stock(50)
                .installments(Installment.builder()
                        .count(10)
                        .amount(43.90)
                        .currency("ARS")
                        .interestFree(true)
                        .build())
                .paymentMethods(PaymentMethods.builder()
                        .credit(List.of("Visa", "MasterCard", "American Express"))
                        .debit(List.of("Visa", "MasterCard"))
                        .cash(List.of("PagoFácil", "RapiPago"))
                        .build())
                .seller(Seller.builder()
                        .id("SELLER123")
                        .name("Samsung Oficial")
                        .reputation("high")
                        .salesCount(5000)
                        .location("Buenos Aires, Argentina")
                        .build())
                .characteristics(List.of(
                        "Memoria RAM: 8 GB",
                        "Procesador Samsung Exynos 1480",
                        "Dispositivo desbloqueado para que lo conectes a cualquier compañía telefónica preferida"))
                .specifications(List.of(Specification.builder()
                        .label("Tamaño de la pantalla")
                        .value("6.6")
                        .build()))
                .shipping(Shipping.builder()
                        .freeShipping(true)
                        .estimatedDelivery("3-5 days")
                        .build())
                .build();
    }

    public static ProductEntity buildMotorolaEdge50Pro() {
        return ProductEntity.builder()
                .id("MLA987654")
                .title("Motorola Edge 50 Pro 5G Dual SIM 512 GB Negro")
                .description("Celular Motorola")
                .price(PriceEntity.builder()
                        .currency("ARS")
                        .amount(649)
                        .decimals(0)
                        .build())
                .discount(0.18)
                .pictures(List.of(
                        "https://mi-cdn.com/images/MLA987654_1.jpg",
                        "https://mi-cdn.com/images/MLA987654_2.jpg",
                        "https://mi-cdn.com/images/MLA987654_3.jpg"))
                .condition("new")
                .soldQuantity(85)
                .stock(40)
                .installments(InstallmentEntity.builder()
                        .count(12)
                        .amount(54.08)
                        .currency("ARS")
                        .interestFree(true)
                        .build())
                .paymentMethods(PaymentMethodsEntity.builder()
                        .credit(List.of("Visa", "Naranja", "Cabal"))
                        .debit(List.of("Visa Débito", "Maestro"))
                        .cash(List.of("MercadoPago", "Transferencia Bancaria"))
                        .build())
                .seller(SellerEntity.builder()
                        .id("SELLER789")
                        .name("Motorola Store")
                        .reputation("medium")
                        .salesCount(3200)
                        .location("Córdoba, Argentina")
                        .build())
                .characteristics(List.of(
                        "Memoria RAM: 8 GB",
                        "Procesador Samsung Exynos 1480",
                        "Dispositivo desbloqueado para que lo conectes a cualquier compañía telefónica preferida"))
                .specifications(List.of(SpecificationEntity.builder()
                        .label("")
                        .value("")
                        .build()))
                .shipping(ShippingEntity.builder()
                        .freeShipping(true)
                        .estimatedDelivery("2-4 days")
                        .build())
                .build();
    }
}
