package ru.yapridu.aptbooking.controllers;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.entities.exceptions.handlers.GlobalExceptionHandler;
import ru.yapridu.aptbooking.business_logic.models.CreateCompanyDTO;
import ru.yapridu.aptbooking.business_logic.models.VersionedModelDTO;
import ru.yapridu.aptbooking.controller_services.CompanyControllerService;

import java.util.List;
import java.util.UUID;

@RestController()
@AllArgsConstructor
@RequestMapping(path = "api/v1/companies", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Company controller", description = "Controller for company management.")
public class CompanyController {
    private static final Logger LOG = LoggerFactory.getLogger(CompanyController.class);
    private final CompanyControllerService companyControllerService;

    @PostMapping(value = "")
    @Operation(description = "Create company")
    @ApiImplicitParam(
            paramType = "body",
            required = true,
            name = "Данные для создания новой компании",
            dataTypeClass = CreateCompanyDTO.class
    )
//    public VersionedModelDTO create(@RequestBody CreateCompanyDTO body) {
//
//        return this.companyControllerService.create(body);
//    }

    public ResponseEntity<?> create(@RequestBody CreateCompanyDTO body) throws JSONException {

        //this.createCompanyValidator.validate(body);
        if (body.getContact().isEmpty()) {

            return ResponseEntity
                    .status(HttpStatus.I_AM_A_TEAPOT)
                    .body("Custom Error Message !!!");
        }

        return new ResponseEntity<>(this.companyControllerService.create(body), HttpStatus.CREATED);
    }


    @GetMapping(value = "")
    @Operation(description = "Find all companies")
    public List<Company> getAll() {

        LOG.trace("Some trace");
        LOG.debug("Some debug");
        LOG.info("Some info");
        LOG.warn("Some warn");
        LOG.error("Some error");

        return this.companyControllerService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find company by UUID")
    @ResponseStatus (HttpStatus.OK)
    public Company getById(@PathVariable("id") UUID id) {

        return this.companyControllerService.getById(id);
    }



    @Operation(description = "Update company fields")
    @PutMapping(value = "")
    public ResponseEntity<VersionedModelDTO> update(@RequestBody CreateCompanyDTO body) {

        return new ResponseEntity<>(this.companyControllerService.update(body), HttpStatus.OK);
    }
}
