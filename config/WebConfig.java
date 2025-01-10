package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all APIs under "/api/**" and from the specified origin
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")  // The frontend address
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true); // Allow credentials (cookies, authentication headers, etc.)
    }
}



/*
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.CorsRegistry; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer; import
 * org.springframework.web.bind.annotation.CrossOrigin;
 * 
 * @CrossOrigin(origins = "http://localhost:8089")
 * 
 * @Configuration public class WebConfig implements WebMvcConfigurer {
 * 
 * @Override public void addCorsMappings(CorsRegistry registry) { // Allow
 * cross-origin requests from Angular app running on localhost:4200
 * registry.addMapping("http://localhost:8089")
 * .allowedOrigins("http://localhost:8089") .allowedMethods("GET", "POST",
 * "PUT", "DELETE") .allowedHeaders("*"); } }
 */
