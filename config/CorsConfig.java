package com.example.Sprint4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow all origins and methods for simplicity, but you should be more restrictive in production.
        registry.addMapping("/**").allowedOrigins("https://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}


