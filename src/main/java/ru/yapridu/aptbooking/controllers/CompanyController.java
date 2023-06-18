package ru.yapridu.aptbooking.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.models.CreateOrUpdateCompanyDTO;
import ru.yapridu.aptbooking.business_logic.models.VersionedModelDTO;
import ru.yapridu.aptbooking.controller_services.CompanyControllerService;
import ru.yapridu.aptbooking.validators.CreateOrUpdateCompanyDtoValidator;

import java.util.List;
import java.util.UUID;

@RestController()
@AllArgsConstructor
@RequestMapping(path = "api/v1/companies", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Company controller", description = "Controller for company management.")
public class CompanyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);
    private final CompanyControllerService companyControllerService;
    private final CreateOrUpdateCompanyDtoValidator createOrUpdateCompanyValidator;

    @PostMapping(value = "", produces = "application/json")
    @Operation(description = "Create new company")
    @ResponseStatus(HttpStatus.CREATED)
    public VersionedModelDTO create(@RequestBody CreateOrUpdateCompanyDTO body) {

        this.createOrUpdateCompanyValidator.validate(body);
        return this.companyControllerService.create(body);
    }

    @GetMapping(value = "", produces = "application/json")
    @Operation(description = "Find all companies")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAll() {

        //Logging level check
        LOGGER.trace("Some trace");
        LOGGER.debug("Some debug");
        LOGGER.info("Some info");
        LOGGER.warn("Some warn");
        LOGGER.error("Some error");

        return this.companyControllerService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find company by UUID")
    @ResponseStatus(HttpStatus.OK)
    public Company getById(@PathVariable("id") UUID id) {

        return this.companyControllerService.getById(id);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Update company fields")
    @ResponseStatus(HttpStatus.OK)
    public VersionedModelDTO update(@PathVariable("id") UUID id, @RequestBody CreateOrUpdateCompanyDTO body) {

        return this.companyControllerService.update(id, body);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Delete company by UUID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") UUID id) {

        this.companyControllerService.deleteById(id);
    }
}