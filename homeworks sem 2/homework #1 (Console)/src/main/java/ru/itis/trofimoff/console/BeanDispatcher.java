package ru.itis.trofimoff.console;

import org.springframework.context.ApplicationContext;
import ru.itis.trofimoff.console.beans.Addition;
import ru.itis.trofimoff.console.beans.Division;
import ru.itis.trofimoff.console.beans.Mult;
import ru.itis.trofimoff.console.beans.Sub;

import java.util.Arrays;

public class BeanDispatcher {
    private final String[] OPERATIONS_LIST = {"+", "-", "/", "*"};
    private ApplicationContext context;

    public BeanDispatcher(ApplicationContext context) {
        this.context = context;
    }

    public Object getBean(String operation) {
        if (!Arrays.asList(OPERATIONS_LIST).contains(operation)) {
            return null;
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
                return null;
            }
        }
    }
}
