package es.cic._5.proy009.controller;

public class ModifySecurityException extends RuntimeException {

    public ModifySecurityException() {
        super("Error: Estás intentando modificar mediante creación");
    }

    public ModifySecurityException(String message) {
        super(message);
    }

    public ModifySecurityException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
