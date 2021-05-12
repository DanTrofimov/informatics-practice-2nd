package ru.itis.trofimoff.exceptions;

public class CantCloseSessionException extends RuntimeException {
    public CantCloseSessionException(String message) {
        super(message);
    }
}
