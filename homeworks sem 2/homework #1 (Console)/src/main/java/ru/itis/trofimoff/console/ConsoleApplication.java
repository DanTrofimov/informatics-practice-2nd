package ru.itis.trofimoff.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.itis.trofimoff.console.beans.Addition;
import ru.itis.trofimoff.console.beans.Division;
import ru.itis.trofimoff.console.beans.Mult;
import ru.itis.trofimoff.console.beans.Sub;

import java.util.Scanner;

//@SpringBootApplication
public class ConsoleApplication {

    public static void main(String[] args) {
        System.out.println("<---- Console Calculator ---->");
        int a;
        int b;
        String  operation;
        ApplicationContext context =
                new FileSystemXmlApplicationContext(ConsoleApplication.class.getResource("/consoleConfig.xml").toString());
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the first number: ");
            a = in.nextInt();
            System.out.println("Enter the second number: ");
            b = in.nextInt();
            System.out.println("Enter the math operation: ");
            operation = in.next();

            switch (operation) {
                case "+": {
                    Addition addBean = (Addition) context.getBean("addition");
                    System.out.println("Result");
                    System.out.println(addBean.performOperation(a, b));
                    break;
                }
                case "-": {
                    Sub subBean = (Sub) context.getBean("subtraction");
                    System.out.println("Result");
                    System.out.println(subBean.performOperation(a, b));
                    break;
                }
                case "*": {
                    Mult multBean = (Mult) context.getBean("multiplication");
                    System.out.println("Result");
                    System.out.println(multBean.performOperation(a, b));
                    break;
                }
                case "/": {
                    Division divBean = (Division) context.getBean("division");
                    System.out.println("Result");
                    System.out.println(divBean.performOperation(a, b));
                    break;
                }
                default: {
                    System.out.println("<---- End ---->");
                    return;
                }
            }
        }
    }
}
