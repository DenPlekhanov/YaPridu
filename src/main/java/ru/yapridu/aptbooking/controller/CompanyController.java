package ru.yapridu.aptbooking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yapridu.aptbooking.model.Company;
import ru.yapridu.aptbooking.service.CompanyService;
import ru.yapridu.aptbooking.service.security.UserService;

import java.util.Date;
import java.util.List;

/**
 * @author Den
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
@Tag(name = "Company", description = "Company management")
@ApiResponse(responseCode = "500", description = "Internal error")
//@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "No company was found")
public class CompanyController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
//    private static final int DEFAULT_PAGINATION_DATA_LIMIT = 10;
//    private static final int DEFAULT_PAGE_NUM = 1;
    private final UserService userService;
    private final CompanyService service;

    @Operation(description = "Find all companies")
    @ApiResponse(responseCode = "200", description = "Companies was found")
    @GetMapping(name = "", produces = "application/json")
    public ResponseEntity<List<Company>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> createCompany(@RequestParam Long userID,
                                              @RequestParam String name,
                                              @RequestParam String address,
                                              @RequestParam String contact,
                                              @RequestParam String officialCompanyDetails,
                                              @RequestParam String description,
                                              @RequestParam Date createdDate,
                                              @RequestParam Date modifiedDate,
                                              @RequestParam Integer version) {
        Company newCompany = Company.builder()
                .owningUser(userService.findUserById(userID)) //TODO Не уверен, что так правильно. Уточнить.
                .name(name)
                .address(address)
                .contact(contact)
                .officialCompanyDetails(officialCompanyDetails)
                .description(description)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .version(version)
                .build();

        Long idOfNewCompany = service.createNewCompany(newCompany).getId();

        return new ResponseEntity<>(idOfNewCompany, HttpStatus.CREATED);
    }
}
