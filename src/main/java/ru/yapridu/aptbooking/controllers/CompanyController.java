package ru.yapridu.aptbooking.controllers;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yapridu.aptbooking.business_logic.entities.Company;
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

    private final CompanyControllerService companyControllerService;

    @PostMapping(value = "")
    @Operation(description = "Create company")
    @ApiImplicitParam(
        paramType = "body",
        required = true,
        name = "Данные для создания кандидата",
        dataTypeClass = CreateCompanyDTO.class
    )
    public VersionedModelDTO create(@RequestBody CreateCompanyDTO body) {

        //TODO this.createCompanyValidator.validate(body);
        return this.companyControllerService.create(body);
    }

    @GetMapping(value = "")
    @Operation(description = "Find all companies")
    public List<Company> getAll() {

        return this.companyControllerService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find company by UUID")
    public ResponseEntity<Company> getById(@PathVariable("id") UUID id) {

        return new ResponseEntity<>(this.companyControllerService.getById(id), HttpStatus.OK);
    }

    @Operation(description = "Update company fields")
    @PutMapping(value = "")
    public ResponseEntity<VersionedModelDTO> update(@RequestBody CreateCompanyDTO body) {

        return new ResponseEntity<>(this.companyControllerService.update(body), HttpStatus.OK);
    }
}
