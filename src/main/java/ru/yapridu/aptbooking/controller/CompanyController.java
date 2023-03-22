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
import ru.yapridu.aptbooking.model.entity.Company;
import ru.yapridu.aptbooking.model.exception.CompanyNotFoundException;
import ru.yapridu.aptbooking.service.CompanyService;
import ru.yapridu.aptbooking.service.security.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Operation(description = "Create new company")
    @ApiResponse(responseCode = "201", description = "Company was created")
    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<UUID> create(@RequestParam Long userId,
                                       @RequestParam String name,
                                       @RequestParam String address,
                                       @RequestParam String contact,
                                       @RequestParam String officialCompanyDetails,
                                       @RequestParam String description,
                                       @RequestParam Date createdDate,
                                       @RequestParam Date modifiedDate,
                                       @RequestParam Integer version) {
        Company newCompany = Company.builder()
                .owningUser(userService.findUserById(userId)) //TODO Не уверен, что так правильно. Уточнить.
                .name(name)
                .address(address)
                .contact(contact)
                .officialCompanyDetails(officialCompanyDetails)
                .description(description)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .version(version)
                .build();
        UUID idOfNewCompany = service.createNewCompany(newCompany).getId();
        return new ResponseEntity<>(idOfNewCompany, HttpStatus.CREATED);
    }

    @Operation(description = "Find all companies")
    @ApiResponse(responseCode = "200", description = "Companies was found")
    @GetMapping(value = "", produces = "application/json")
//    @PreAuthorize("hasAnyRole('ADMIN', 'ORGANIZER')")
    public ResponseEntity<List<Company>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(description = "Find company by UUID")
    @ApiResponse(responseCode = "200", description = "Company was found")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Company> findById(@PathVariable("id") UUID id) {
        Optional<Company> company = service.findById(id);
        if (company.isEmpty()) {
//            return ResponseEntity.notFound();
            throw new CompanyNotFoundException(id);
        }
        return new ResponseEntity<>(company.get(), HttpStatus.OK);
        //TODO Не нравится разворачивание Optional`a. Возможно нужен рефакторинг.
    }

    @Operation(description = "Update company fields")
    @ApiResponse(responseCode = "200", description = "Company was updated")
    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity.HeadersBuilder<?> update(@RequestParam UUID id,
                                                   @RequestParam String name,
                                                   @RequestParam String address,
                                                   @RequestParam String contact,
                                                   @RequestParam String officialCompanyDetails,
                                                   @RequestParam String description,
                                                   @RequestParam Date modifiedDate,
                                                   @RequestParam Integer version) {
        Optional<Company> companyOptional = service.findById(id);
        if (companyOptional.isEmpty()) {
//            return ResponseEntity.notFound();
            throw new CompanyNotFoundException(id);
        }
        Company company = companyOptional.get();
        company.setName(name);
        company.setAddress(address);
        company.setContact(contact);
        company.setOfficialCompanyDetails(officialCompanyDetails);
        company.setDescription(description);
        company.setModifiedDate(modifiedDate);
        company.setVersion(company.getVersion()+1);
        service.update(company);
        return ResponseEntity.ok();
    }

    @Operation(description = "Delete company by ID")
    @ApiResponse(responseCode = "200", description = "Company was deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity.HeadersBuilder<?> deleteById(@PathVariable("id") UUID id) {
        Optional<Company> company = service.findById(id);
        if (company.isEmpty()) {
//            return ResponseEntity.notFound();
            throw new CompanyNotFoundException(id);
        }
        service.deleteById(id);
        return ResponseEntity.ok();
    }
}