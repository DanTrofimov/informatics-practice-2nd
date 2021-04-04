package ru.itis.trofimoff.lazy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itis.trofimoff.lazy.converter.CategoryConverter;

@Configuration
@ComponentScan("ru.itis.trofimoff.lazy")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CategoryConverter());
    }
}
