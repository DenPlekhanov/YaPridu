package ru.yapridu.aptbooking.business_logic.entities.exceptions.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yapridu.aptbooking.business_logic.entities.exceptions.ErrorMessageContainer;
import ru.yapridu.aptbooking.business_logic.entities.exceptions.ResourceNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ErrorMessageContainer> catchResourceNotFoundException(ResourceNotFoundException e) {

        Map<String, String> moreErrorDetailsMap = new LinkedHashMap<>();
        moreErrorDetailsMap.put("Detail1", "MoreDetail1");
        moreErrorDetailsMap.put("Detail2", "MoreDetail2");
        long timestamp = System.currentTimeMillis(); //Timestamp в миллисекундах временно в качестве идентификатора ошибки.
        LOG.error("| Error id: {} | Error message: {} | {}", timestamp, e.getMessage(), moreErrorDetailsMap);

        return new ResponseEntity<>(new ErrorMessageContainer(timestamp, HttpStatus.NOT_FOUND.value(), e.getMessage(), moreErrorDetailsMap)
                , HttpStatus.NOT_FOUND);
    }
}