package ru.yapridu.aptbooking.business_logic.entities.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yapridu.aptbooking.business_logic.entities.exceptions.CommonErrorMessageContainer;
import ru.yapridu.aptbooking.business_logic.entities.exceptions.ResourceNotFoundException;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
//@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CommonErrorMessageContainer> catchResourceNotFoundException(ResourceNotFoundException e) {

        Map<String, String> moreErrorDetailsMap = new LinkedHashMap<>();
        long timestamp = System.currentTimeMillis(); //Timestamp в миллисекундах в качестве идентификатора ошибки.
//        log.error(timestamp.toString(), e.getMessage(), e, moreErrorDetailsMap);

        return new ResponseEntity<>(new CommonErrorMessageContainer(timestamp, HttpStatus.NOT_FOUND.value(), e.getMessage(), moreErrorDetailsMap)
                , HttpStatus.NOT_FOUND);
    }
}