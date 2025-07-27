# ▶️ Ejecución Local de la API de Productos

## Requisitos previos

- Java 24+ instalado
- Maven 3.8+ instalado
- Puerto 8080

## Pasos para levantar la aplicación

1. Clona el repositorio
   ```bash
   git clone https://github.com/maria927/meli-challenge-be.git
   meli-challenge-be
   ```
2. Compila y ejecuta con Maven

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

Verifica que esté corriendo:

- Swagger UI: http://localhost:8080/meli-products/swagger-ui/index.html. *Probar con los siguientes ids de productos: ML1 y ML2*
- Actuator Health check: http://localhost:8080/meli-products/actuator/health
- Actuator Metrics: http://localhost:8080/meli-products/actuator/metrics

Ejecución de pruebas:
- Ejecuta todas las pruebas unitarias y de integración:

```bash
mvn test
```

- Informes de cobertura en target/site/jacoco/index.html