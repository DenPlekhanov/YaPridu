package ru.yapridu.aptbooking.business_logic.services.entities;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.models.CreateCompanyDTO;
import ru.yapridu.aptbooking.repository.CompanyRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    public Company create(CreateCompanyDTO companyData) {

        Company company = Company.builder()
            .ownerId(companyData.getOwnerId())
            .name(companyData.getName())
            .address(companyData.getAddress())
            .contact(companyData.getContact())
            .officialDetails(companyData.getOfficialCompanyDetails())
            .description(companyData.getDescription())
            .build();

        return repository.save(company);
    }

    public List<Company> getAll() {

        return repository.findAll();
    }

}
