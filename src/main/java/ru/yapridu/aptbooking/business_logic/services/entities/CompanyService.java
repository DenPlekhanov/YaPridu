package ru.yapridu.aptbooking.business_logic.services.entities;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.models.CreateOrUpdateCompanyDTO;
import ru.yapridu.aptbooking.exceptions.SystemException;
import ru.yapridu.aptbooking.repository.CompanyRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    public Company create(CreateOrUpdateCompanyDTO companyData) {

        Company newCompany = Company.builder()
            .ownerId(companyData.getOwnerId())
            .name(companyData.getName())
            .address(companyData.getAddress())
            .contact(companyData.getContact())
            .officialDetails(companyData.getOfficialDetails())
            .description(companyData.getDescription())
            .build();
        return repository.save(newCompany);
    }

    public List<Company> getAll() {

        return repository.findAll();
    }

    public Company getById(UUID id) {

        return repository.findById(id).orElseThrow(
            () -> new SystemException("Company with id " + id + " not found."));
    }

    public Company update(UUID id, CreateOrUpdateCompanyDTO companyData) {

        Company companyToUpdate = repository.findById(id).orElseThrow(
                () -> new SystemException("Company cannot be updated because company with id " + id + " not found."));
        companyToUpdate.setOwnerId(companyData.getOwnerId());
        companyToUpdate.setName(companyData.getName());
        companyToUpdate.setAddress(companyData.getAddress());
        companyToUpdate.setContact(companyData.getContact());
        companyToUpdate.setOfficialDetails(companyData.getOfficialDetails());
        companyToUpdate.setDescription(companyData.getDescription());

        return repository.save(companyToUpdate);
    }

    public void deleteById(UUID id) {

        repository.findById(id).orElseThrow(
                () -> new SystemException("Company cannot be deleted because Company with id " + id + " not found."));
        repository.deleteById(id);
    }
}
