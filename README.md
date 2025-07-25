# 🛍️ API de Productos

## Descripción

Este proyecto expone una API RESTful para gestionar productos, construida en Java 21 con Spring Boot.  
Se basa en arquitectura hexagonal para aislar dominio, casos de uso e infraestructura, facilitando la escalabilidad y testabilidad.

## Características técnicas

- Arquitectura Hexagonal (Ports & Adapters)
- Principios SOLID aplicados en cada capa
- MapStruct para mapeo limpio entre entidades y DTOs
- Swagger/OpenAPI para documentación interactiva
- Manejo centralizado de errores con ControllerAdvice
- Logging transversal (AOP + anotaciones personalizadas)
- Actuator para monitoreo y administración de la aplicación en tiempo real
- Pruebas unitarias con JUnit 5, Mockito y MockMvc  

## Endpoint

-**Método:** GET

-**Ruta:** /meli-products/api/v1/products/{id}

-**Descripción:** Obtiene un producto por su identificador

## Documentación

Documentación completa en:  
http://localhost:8080/meli-products/swagger-ui/index.html

## Requisitos

- Java 21 o superior
- Maven 3.8 o superior 