package ru.yapridu.aptbooking.business_logic.services.entities;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.entities.exceptions.ResourceNotFoundException;
import ru.yapridu.aptbooking.business_logic.models.CreateCompanyDTO;
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
            () -> new ResourceNotFoundException("Company with id " + id + " not found"));
    }

/*
    public Company getById(UUID id) {
        Optional<Company> companyFromDb = repository.findById(id);
        if (companyFromDb.isPresent()) {
            return companyFromDb.get();
        } else throw new CompanyNotFoundException("Company with id "+ id +" was not found.");
    }
*/
    public void deleteById(UUID id) {

        repository.deleteById(id);
    }
}
