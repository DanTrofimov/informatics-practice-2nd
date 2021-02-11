package ru.itis.trofimoff.beans;

public class Division implements MathOperation {
    @Override
    public int performOperation(int a, int b) {
        return a / b;
    }
}
