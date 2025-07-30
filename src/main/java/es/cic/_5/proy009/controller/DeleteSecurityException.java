package es.cic._5.proy009.controller;

public class DeleteSecurityException extends RuntimeException {

    public DeleteSecurityException() {
        super("Error: no puedes enviar un ID vacío.");
    }

    public DeleteSecurityException(String message) {
        super(message);
    }

    public DeleteSecurityException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
