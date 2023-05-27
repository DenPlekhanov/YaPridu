package ru.yapridu.aptbooking.exceptions.handlers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yapridu.aptbooking.exceptions.ErrorMessageContainer;
import ru.yapridu.aptbooking.exceptions.SystemException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ErrorMessageContainer> catchResourceNotFoundException(SystemException e) {

        LOGGER.error(
            "\nError id: {}\nError code: {}\nOperation code: {}\nError message: {}",
            e.getId(), e.getErrorCode(), e.getOperationCode(), e.getMessage()
        );

        return new ResponseEntity<>(new ErrorMessageContainer(e), e.getErrorCode().getSemantics());
    }
}
