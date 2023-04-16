package ru.yapridu.aptbooking.business_logic.models;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateCompanyDTO {

    private UUID ownerId;

    private String name;

    private String address;

    private String contact;

    private String officialCompanyDetails;

    private String description;

}
