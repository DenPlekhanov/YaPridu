package ru.yapridu.aptbooking.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    
    EC_001(HttpStatus.BAD_REQUEST, "Company name not set");

    private final HttpStatus semantics;

    private final String description;

}
