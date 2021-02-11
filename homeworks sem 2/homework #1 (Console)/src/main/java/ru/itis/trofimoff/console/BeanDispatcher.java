package ru.itis.trofimoff.console;

import org.springframework.context.ApplicationContext;
import ru.itis.trofimoff.console.beans.*;
import ru.itis.trofimoff.console.exceptions.UnknownOperationException;

import java.util.Arrays;

public class BeanDispatcher {
    private final String[] OPERATIONS_LIST = {"+", "-", "/", "*"};
    private ApplicationContext context;

    public BeanDispatcher(ApplicationContext context) {
        this.context = context;
    }

    public MathOperation getBean(String operation) throws UnknownOperationException {
        if (!Arrays.asList(OPERATIONS_LIST).contains(operation)) {
            throw new UnknownOperationException("Unknown operation. Exiting...");
        };
        switch (operation) {
            case "+": {
                return (Addition) context.getBean("addition");
            }
            case "-": {
                return (Sub) context.getBean("subtraction");
            }
            case "*": {
                return (Mult) context.getBean("multiplication");
            }
            case "/": {
                return (Division) context.getBean("division");
            }
            default: {
                throw new UnknownOperationException("Unknown operation. Exiting...");
            }
        }
    }
}
