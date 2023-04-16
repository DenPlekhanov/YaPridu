package ru.yapridu.aptbooking.controllers;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yapridu.aptbooking.business_logic.models.CreateCompanyDTO;
import ru.yapridu.aptbooking.business_logic.models.VersionedModelDTO;
import ru.yapridu.aptbooking.controller_services.CompanyControllerService;

@RestController()
@AllArgsConstructor
@RequestMapping(path = "api/v1/companies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {

    private final CompanyControllerService companyControllerService;

    @PostMapping()
    @ApiOperation(value = "Create company")
    @ApiImplicitParam(
        paramType = "body",
        required = true,
        name = "Данные для создания кандидата",
        dataTypeClass = CreateCompanyDTO.class
    )
    @ApiResponse(
        code = 200,
        message = "Данные созданного кандидата",
        response = VersionedModelDTO.class
    )
    public VersionedModelDTO create(@RequestBody CreateCompanyDTO body) {

        //this.createCompanyValidator.validate(body);

        return this.companyControllerService.create(body);
    }


}
