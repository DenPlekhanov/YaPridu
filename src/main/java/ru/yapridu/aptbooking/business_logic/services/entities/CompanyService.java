package ru.yapridu.aptbooking.business_logic.services.entities;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.models.CreateCompanyDTO;
import ru.yapridu.aptbooking.repositories_ebean.CompanyEbeanRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyEbeanRepository repository;

    public Company create(CreateCompanyDTO companyData) {

        Company company = Company.builder()
            .ownerId(companyData.getOwnerId())
            .name(companyData.getName())
            .address(companyData.getAddress())
            .contact(companyData.getContact())
            .officialDetails(companyData.getOfficialCompanyDetails())
            .description(companyData.getDescription())
            .build();

        return repository.insert(company);
    }

    public List<Company> getAll() {

        return repository.findAll();
    }

}
