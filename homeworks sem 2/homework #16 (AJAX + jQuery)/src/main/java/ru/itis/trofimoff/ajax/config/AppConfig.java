package ru.itis.trofimoff.ajax.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    // view resolver
    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html;charset=UTF-8");

        return resolver;
    }

    // spring static mapping
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/styles/**").addResourceLocations("classpath:/static/styles/");
        registry.addResourceHandler("/static/assets/**").addResourceLocations("classpath:/static/assets/");
        registry.addResourceHandler("/static/scripts/**").addResourceLocations("classpath:/static/scripts/");
    }


}
