package com.meli.challenge.infraestructure.adapter.port.shared.exception;

public class ReadFileException extends RuntimeException {

    public ReadFileException(String message) {
        super("Exception reading file " + message);
    }

}
