package com.mikor.carback.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Сarsharing Server API",
                description = "Описание всех эндпоинтов сервера \"carsharing\"",
                contact = @Contact(name = "Михаил королицкий"),
                version = "1.0.3"),
        servers = {
                @Server(url = "http://localhost:8080")
        })
public class SwaggerConfig {
    //http://localhost:8080
}