package ru.itis.trofimoff.exseptions;

public class UnknownOperationException extends Exception {
    public UnknownOperationException(String message){
        super(message);
    }
}
