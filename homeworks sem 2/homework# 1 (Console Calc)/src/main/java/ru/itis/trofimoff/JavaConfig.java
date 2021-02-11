package ru.itis.trofimoff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.trofimoff.beans.Addition;
import ru.itis.trofimoff.beans.Division;
import ru.itis.trofimoff.beans.Multiplication;
import ru.itis.trofimoff.beans.Substraction;

@Configuration
public class JavaConfig {
    @Bean
    public Addition addition(){
        return new Addition();
    }

    @Bean
    public Division division(){
        return new Division();
    }

    @Bean
    public Multiplication multiplication(){
        return new Multiplication();
    }

    @Bean
    public Substraction substraction(){
        return new Substraction();
    }
}
