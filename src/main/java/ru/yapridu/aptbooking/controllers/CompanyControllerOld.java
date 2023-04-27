package ru.yapridu.aptbooking.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yapridu.aptbooking.business_logic.entities.CompanyOld;
import ru.yapridu.aptbooking.business_logic.services.CompanyServiceOld;
import ru.yapridu.aptbooking.business_logic.services.UserService;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Den
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
@Tag(name = "Company (old controller)", description = "Controller for company management.")
@ApiResponse(responseCode = "500", description = "Internal error")
//  @ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "No company was found")
public class CompanyControllerOld {
    private static final Logger logger = LoggerFactory.getLogger(CompanyControllerOld.class);
//    private static final int DEFAULT_PAGINATION_DATA_LIMIT = 10;
//    private static final int DEFAULT_PAGE_NUM = 1;
    private final UserService userService;
    private final CompanyServiceOld service;

/*
    @Operation(description = "Create new company")
    @ApiResponse(responseCode = "201", description = "Company was created")
    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<UUID> create(@RequestParam Long userId,
                                       @RequestParam String name,
                                       @RequestParam String address,
                                       @RequestParam String contact,
                                       @RequestParam String officialCompanyDetails,
                                       @RequestParam String description,
                                       @RequestParam Integer version) {
        Date creatingTime = Date.from(Instant.now()); //TODO Разобраться с датами
        CompanyOld newCompany = CompanyOld.builder()
                //.owningUser(userService.findById(userId))
                .name(name)
                .address(address)
                .contact(contact)
                .officialCompanyDetails(officialCompanyDetails)
                .description(description)
//                .createdDate(creatingTime)
//                .modifiedDate(creatingTime)
                .version(version)
                .build();
        UUID idOfNewCompany = service.createNewCompany(newCompany).getId();
        return new ResponseEntity<>(idOfNewCompany, HttpStatus.CREATED);
    }
*/

/*
    @Operation(description = "Find all companies")
    @ApiResponse(responseCode = "200", description = "Companies was found")
    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<CompanyOld>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
*/

/*
    @Operation(description = "Find company by UUID")
    @ApiResponse(responseCode = "200", description = "Company was found")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CompanyOld> findById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
*/

/*
    @Operation(description = "Update company fields")
    @ApiResponse(responseCode = "200", description = "Company was updated")
    @PutMapping(value = "", produces = "application/json")
    public ResponseEntity<CompanyOld> update(@RequestParam UUID id,
                                             @RequestParam String name,
                                             @RequestParam String address,
                                             @RequestParam String contact,
                                             @RequestParam String officialCompanyDetails,
                                             @RequestParam String description) {
        CompanyOld company = service.findById(id);
        company.setName(name);
        company.setAddress(address);
        company.setContact(contact);
        company.setOfficialCompanyDetails(officialCompanyDetails);
        company.setDescription(description);
//        company.setModifiedDate(modifiedDate);
        company.setVersion(company.getVersion() + 1);
        CompanyOld updatedCompany = service.update(company);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }
*/

/*
    @Operation(description = "Delete company by ID")
    @ApiResponse(responseCode = "200", description = "Company was deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") UUID id) {
        service.findById(id); //Проверка успешного нахождения сущности в БД реализована в методе Service слоя
        service.deleteById(id);
        return new ResponseEntity<>("Company with id " + id + " was deleted", HttpStatus.OK);
    }
*/

}
