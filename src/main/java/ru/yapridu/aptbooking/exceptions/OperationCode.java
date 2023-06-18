package ru.yapridu.aptbooking.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OperationCode {

    OC_01("Create company");

    private final String description;

}
