package ru.yapridu.aptbooking.controllers;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "", produces = "application/json")
    @Operation(description = "Create company") //@ApiOperation(value = "Create company")
    @ApiImplicitParam(
            paramType = "body",
            required = true,
            name = "Данные для создания кандидата",
            dataTypeClass = CreateCompanyDTO.class
    )
//    @ApiResponse(
//            code = 200,
//            message = "Данные созданного кандидата",
//            response = VersionedModelDTO.class
//    )
    @ApiResponse(responseCode = "201", description = "The company has been successfully created.",
            content =  { @Content(mediaType = "application/json",
            schema = @Schema(implementation = VersionedModelDTO.class)) })
    @ApiResponse(responseCode = "400", description = "Bad Request.",
            content =  { @Content(mediaType = "application/json",
            schema = @Schema(implementation = String.class /*, defaultValue = "Bad Request!!!"*/)) })
    @ApiResponse(responseCode = "401", description = "Unauthorized request.")
    @ApiResponse(responseCode = "500", description = "Internal Server Error.")
    //@ApiImplicitParam - отсутствует в Swagger 3.0
    public ResponseEntity<VersionedModelDTO> create(@RequestBody CreateCompanyDTO body) {
//    public VersionedModelDTO create(@RequestBody CreateCompanyDTO body) {
        //this.createCompanyValidator.validate(body);
//        return this.companyControllerService.create(body);
        return new ResponseEntity<>(this.companyControllerService.create(body), HttpStatus.CREATED);
    }

    @GetMapping(value = "", produces = "application/json")
    @Operation(description = "Find all companies")
    @ApiResponse(responseCode = "200", description = "Companies was found")
//    public List<Company> getAll() {
//        return this.companyControllerService.getAll();
    public ResponseEntity<List<Company>> getAll() {
        return new ResponseEntity<>(this.companyControllerService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(description = "Find company by UUID")
    @ApiResponse(responseCode = "200", description = "Company was found")
    public ResponseEntity<Company> getById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(this.companyControllerService.getById(id), HttpStatus.OK);
    }

    @Operation(description = "Update company fields")
    @ApiResponse(responseCode = "200", description = "Company was updated")
    @PutMapping(value = "", produces = "application/json")
    public ResponseEntity<VersionedModelDTO> update(@RequestBody CreateCompanyDTO body) {
        return new ResponseEntity<>(this.companyControllerService.update(body), HttpStatus.OK);
    }
}