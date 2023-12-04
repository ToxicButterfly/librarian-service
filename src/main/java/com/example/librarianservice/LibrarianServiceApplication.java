package com.example.librarianservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(
                title = "Librarian API",
                version = "1.0",
                description = "Microservice for book controlling"
        )
)
public class LibrarianServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarianServiceApplication.class, args);
    }

}
