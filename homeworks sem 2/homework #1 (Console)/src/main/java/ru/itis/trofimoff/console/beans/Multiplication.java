package ru.itis.trofimoff.console.beans;

public class Multiplication implements MathOperation {
    @Override
    public int performOperation(int a, int b) {
        return a * b;
    }
}
