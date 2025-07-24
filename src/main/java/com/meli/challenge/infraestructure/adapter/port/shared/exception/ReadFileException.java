package com.meli.challenge.infraestructure.adapter.port.shared.exception;

public class ReadFileException extends RuntimeException {

    public ReadFileException(Exception e) {
        super("Exception reading file " + e);
    }

}
