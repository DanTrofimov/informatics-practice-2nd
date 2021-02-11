package ru.itis.trofimoff.console;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.itis.trofimoff.console.exceptions.UnknownOperationException;

import java.util.Scanner;

//@SpringBootApplication
public class ConsoleApplication {

    public static void main(String[] args) {
        System.out.println("<---- Console Calculator ---->");
        int a;
        int b;
        int result;
        String  operation;
        BeanDispatcher beanDispatcher = new BeanDispatcher(new FileSystemXmlApplicationContext(ConsoleApplication.class.getResource("/consoleConfig.xml").toString()));
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the first number: ");
            a = in.nextInt();
            System.out.println("Enter the second number: ");
            b = in.nextInt();
            System.out.println("Enter the math operation: ");
            operation = in.next();

            try {
                result = beanDispatcher.getBean(operation).performOperation(a, b);
            } catch (UnknownOperationException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            System.out.println("Result:");
            System.out.println(result);
        }
    }
}
