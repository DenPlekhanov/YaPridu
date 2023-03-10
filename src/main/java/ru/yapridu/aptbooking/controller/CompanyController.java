package ru.yapridu.aptbooking.controller;

import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    private final UserService userService;
    private final CompanyService service;
    
//    @ApiOperation(value = "Получить список всех компаний.", nickname = "getAll")
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

        return new ResponseEntity<>(idOfNewCompany,HttpStatus.CREATED);
    }
}
