package ru.itis.trofimoff.form.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ru.itis.trofimoff.form.repository.user.UserRepositoryImpl;
import ru.itis.trofimoff.form.repository.utils.DataBaseConnector;
import ru.itis.trofimoff.form.services.user.UserServiceImpl;
import ru.itis.trofimoff.form.services.user.UserValidator;

@Configuration
@ComponentScan("ru.itis.trofimoff.form.controllers")
@ComponentScan("ru.itis.trofimoff.form.repository.utils")
@EnableWebMvc
public class Config implements WebMvcConfigurer {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    resolver.setRedirectContextRelative(false);
    return resolver;
  }

  @Bean
  public UserValidator validator(){
    return new UserValidator();
  }

  @Bean
  public UserServiceImpl userService() {
    return new UserServiceImpl(userRepository());
  }

  @Bean
  public UserRepositoryImpl userRepository() {
    return new UserRepositoryImpl(dataBaseConnector());
  }

  @Bean
  public DataBaseConnector dataBaseConnector() {
    return new DataBaseConnector();
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("form");
    registry.addViewController("/").setViewName("profile");
  }
}
