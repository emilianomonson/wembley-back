package com.wembley.utileria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WembleyUtileriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WembleyUtileriaApplication.class, args);
    }

    @Configuration
    public static class WebConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            // Esto permite que las fotos guardadas en la carpeta "uploads"
            // sean accesibles vía web (ej: localhost:8080/imagenes/botin.jpg)
            registry.addResourceHandler("/imagenes/**")
                    .addResourceLocations("file:uploads/");
        }
    }
}