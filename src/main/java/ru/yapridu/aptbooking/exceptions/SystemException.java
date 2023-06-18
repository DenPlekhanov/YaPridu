package ru.yapridu.aptbooking.exceptions;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class SystemException extends RuntimeException {

    private final UUID id;

    private final ErrorCode errorCode;

    private final OperationCode operationCode;

    public SystemException(
        String message
    ) {
        this(message, null, null, null);
    }

    public SystemException(
        String message,
        ErrorCode errorCode,
        OperationCode operationCode,
        Throwable cause
    ) {
        super(message, cause);
        this.id = UUID.randomUUID();
        this.errorCode = errorCode;
        this.operationCode = operationCode;
    }

    public UUID getId() {
        return this.id;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public OperationCode getOperationCode() {
        return this.operationCode;
    }
}
