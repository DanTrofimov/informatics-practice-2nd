package ru.itis.trofimoff.beans;

public class Addition implements MathOperation {
    @Override
    public int performOperation(int a, int b) {
        return a + b;
    }
}
