package ru.yapridu.aptbooking.business_logic.services.entities;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.models.CreateCompanyDTO;
import ru.yapridu.aptbooking.exceptions.SystemException;
import ru.yapridu.aptbooking.repository.CompanyRepository;

import java.util.List;
import java.util.UUID;

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

    public Company getById(UUID id) {

        return repository.findById(id).orElseThrow(
            () -> new SystemException("Company with id " + id + " not found."));
    }

    public void deleteById(UUID id) {

        repository.findById(id).orElseThrow(
                () -> new SystemException("Company cannot be deleted because Company with id " + id + " not found."));
        repository.deleteById(id);
    }
}
