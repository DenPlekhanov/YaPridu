package ru.yapridu.aptbooking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MyBCryptPasswordEncoderConfig {
    @Bean
    public BCryptPasswordEncoder myBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}