package ru.itis.trofimoff.console.beans;

public class Mult implements MathOperation {
    @Override
    public int performOperation(int a, int b) {
        return a * b;
    }
}
