package ru.yapridu.aptbooking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (info = @Info(title = "YaPridu API", version = "1"))
public class AptBooking {
    public static void main(String[] args) {
        SpringApplication.run(AptBooking.class, args);
    }
}