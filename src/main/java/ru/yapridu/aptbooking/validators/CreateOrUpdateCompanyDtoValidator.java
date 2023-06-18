package ru.yapridu.aptbooking.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.yapridu.aptbooking.business_logic.models.CreateOrUpdateCompanyDTO;
import ru.yapridu.aptbooking.exceptions.ErrorCode;
import ru.yapridu.aptbooking.exceptions.OperationCode;
import ru.yapridu.aptbooking.exceptions.SystemException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CreateOrUpdateCompanyDtoValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrUpdateCompanyDtoValidator.class);
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void /*Set<String>*/ validate(CreateOrUpdateCompanyDTO objectToValidate) {

        LOGGER.error("Вызвался валидатор и метод валидации для CreateOrUpdateCompanyDTO");
        Set<ConstraintViolation<CreateOrUpdateCompanyDTO>> violations = validator.validate(objectToValidate);

        if (!violations.isEmpty()) {

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (ConstraintViolation<CreateOrUpdateCompanyDTO> violation: violations) {
                System.out.println(violation.getMessage());
                System.out.println(violation.getConstraintDescriptor());
                System.out.println(violation.getMessageTemplate());
                System.out.println(violation.getPropertyPath());
                System.out.println(violation.getInvalidValue());
                System.out.println("-----------------------------------------");
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            List<String> violationsSet = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            String violationsString = String.join(" | ", violationsSet);

//            violationsSet.forEach();

            LOGGER.warn("Печать violations:");
            LOGGER.warn(violationsString); //TODO указывает только "не должно быть пустым", но нет названия параметра который пришел пустым
            LOGGER.warn("*************************** Печать violations окончена");
            throw new SystemException(violationsString, ErrorCode.EC_002, OperationCode.OC_01, null);
        }
    }
}