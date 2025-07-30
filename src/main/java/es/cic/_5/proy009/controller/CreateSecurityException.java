package es.cic._5.proy009.controller;

public class CreateSecurityException extends RuntimeException {

    public CreateSecurityException() {
        super("Error: no puedes mandar un ID a la hora de crear.");
    }

    public CreateSecurityException(String message) {
        super(message);
    }

    public CreateSecurityException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
