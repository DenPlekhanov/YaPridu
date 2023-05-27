package ru.yapridu.aptbooking.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ErrorMessageContainer {

    private final UUID id;
    private final ErrorCode errorCode;
    private final OperationCode operationCode;
    private final String message;

    public ErrorMessageContainer(SystemException e) {
        this.id = e.getId();
        this.errorCode = e.getErrorCode();
        this.operationCode = e.getOperationCode();
        this.message = e.getErrorCode().getDescription();
    }
}
