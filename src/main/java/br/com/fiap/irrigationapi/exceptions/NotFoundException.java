package br.com.fiap.irrigationapi.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, Long id) {
        super(message + "(id: " + id + ") not found...");
    }

    public NotFoundException(String message, String email) {
        super(message + "(email: " + email + ") not found...");
    }
}
