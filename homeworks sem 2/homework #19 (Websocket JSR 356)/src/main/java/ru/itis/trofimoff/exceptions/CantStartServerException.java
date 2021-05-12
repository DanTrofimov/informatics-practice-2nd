package ru.itis.trofimoff.exceptions;

public class CantStartServerException extends RuntimeException {
    public CantStartServerException(String message) {
        super(message);
    }
}
