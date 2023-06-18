package ru.yapridu.aptbooking.business_logic.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class CreateOrUpdateCompanyDTO {

    @NonNull // TODO ошибка при валидации @NotEmpty для UUID - "HV000030: No validator could be found for constraint 'javax.validation.constraints.NotEmpty' validating type 'java.util.UUID'."
    private UUID ownerId;

    @NonNull @NotEmpty
    private String name;

    @NonNull @NotEmpty
    private String address;

    @NonNull @NotEmpty
    private String contact;

    @NonNull @NotEmpty
    private String officialDetails;

    @NonNull @NotEmpty
    private String description;

}
