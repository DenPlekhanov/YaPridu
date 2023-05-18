package ru.yapridu.aptbooking.business_logic.entities.exceptions.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<CommonErrorMessageContainer> catchResourceNotFoundException(ResourceNotFoundException e) {


        Map<String, String> moreErrorDetailsMap = new LinkedHashMap<>();
        moreErrorDetailsMap.put("Detail1", "MoreDetail1");
        long timestamp = System.currentTimeMillis(); //Timestamp в миллисекундах временно в качестве идентификатора ошибки.
        LOG.error("Error id: " + timestamp + ".", e.getMessage(), e, moreErrorDetailsMap);
        LOG.trace("Трэйс");

        return new ResponseEntity<>(new CommonErrorMessageContainer(timestamp, HttpStatus.NOT_FOUND.value(), e.getMessage(), moreErrorDetailsMap)
                , HttpStatus.NOT_FOUND);
    }
}