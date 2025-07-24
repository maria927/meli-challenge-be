package com.meli.challenge.infraestructure.adapter.port.shared;

import com.meli.challenge.application.exception.ProductNotFoundException;
import com.meli.challenge.infraestructure.adapter.port.shared.dto.ErrorResponse;
import com.meli.challenge.infraestructure.adapter.port.shared.exception.ReadFileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException e){
        return defaultErrorResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReadFileException.class)
    public ResponseEntity<ErrorResponse> handleReadFileException(ReadFileException e){
        return defaultErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception e){
        return defaultErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static ResponseEntity<ErrorResponse> defaultErrorResponse(Exception e, HttpStatus internalServerError) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return ResponseEntity.status(internalServerError).body(errorResponse);
    }

}
