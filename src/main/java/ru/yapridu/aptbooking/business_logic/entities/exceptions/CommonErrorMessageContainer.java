package ru.yapridu.aptbooking.business_logic.entities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommonErrorMessageContainer {
    private long errorIdentifier;
    private int errorCode;
    private String message;
    private Map<String, String> moreErrorDetailsMap;

    public CommonErrorMessageContainer(long errorIdentifier, int errorCode, String message) {
        this.errorIdentifier = errorIdentifier;
        this.errorCode = errorCode;
        this.message = message;
        this.moreErrorDetailsMap = new LinkedHashMap<>();
    }

}