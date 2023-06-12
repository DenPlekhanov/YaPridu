package ru.yapridu.aptbooking.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    
    EC_001(HttpStatus.BAD_REQUEST, "Company name not set"),
    EC_002(HttpStatus.BAD_REQUEST, "Not all required fields have been set");

    private final HttpStatus semantics; //TODO почему бы назвать поле httpStatus... Semantics не информативно.

    private final String description;

}
