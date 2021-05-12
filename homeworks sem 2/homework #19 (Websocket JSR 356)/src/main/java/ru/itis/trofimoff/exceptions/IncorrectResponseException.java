package ru.itis.trofimoff.exceptions;

public class IncorrectResponseException extends RuntimeException {
    public IncorrectResponseException(String message) {
        super(message);
    }
}
