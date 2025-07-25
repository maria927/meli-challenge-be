package com.meli.challenge.infraestructure.adapter.port.in.controller;

import com.meli.challenge.application.exception.ProductNotFoundException;
import com.meli.challenge.application.port.in.ProductServicePort;
import com.meli.challenge.domain.model.product.ProductResponse;
import com.meli.challenge.infraestructure.adapter.port.shared.GlobalExceptionHandler;
import com.meli.challenge.infraestructure.adapter.port.shared.exception.ReadFileException;
import com.meli.challenge.mocks.ProductMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(GlobalExceptionHandler.class)
@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductServicePort service;

    @Test
    void getProductWhenExists() throws Throwable {

        ProductResponse product = ProductMock.buildSamsungGalaxyA55();
        when(service.getProductById("MLA123")).thenReturn(product);


        mockMvc.perform(get("/api/v1/products/MLA123")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(product.id()))
                .andExpect(jsonPath("$.condition").value(product.condition()))
                .andExpect(jsonPath("$.description").value(product.description()));

        Mockito.verify(service, times(1)).getProductById(anyString());
    }

    @Test
    void returnNotFoundWhenProductNotFound() throws Exception {

        String productId = "MLA000";
        when(service.getProductById(productId)).thenThrow(new ProductNotFoundException(productId));


        mockMvc.perform(get("/api/v1/products/"+productId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Product not found: MLA000"));

        Mockito.verify(service, times(1)).getProductById(anyString());
    }

    @Test
    void returnReadFileExceptionWhenGetFileFromJson() throws Exception {

        String productId = "MLA000";
        when(service.getProductById(productId)).thenThrow(new ReadFileException(productId));


        mockMvc.perform(get("/api/v1/products/"+productId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.message").value("Exception reading file MLA000"));

        Mockito.verify(service, times(1)).getProductById(anyString());
    }

    @Test
    void return500ServerErrorWhenGetAnyGeneralException() throws Exception {

        String productId = "MLA000";
        when(service.getProductById(productId)).thenThrow(new RuntimeException("Exception"));


        mockMvc.perform(get("/api/v1/products/"+productId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());

        Mockito.verify(service, times(1)).getProductById(anyString());
    }
}
