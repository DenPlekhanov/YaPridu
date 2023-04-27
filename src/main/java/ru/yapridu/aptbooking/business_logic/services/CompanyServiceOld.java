package ru.yapridu.aptbooking.business_logic.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.entities.exception.CompanyNotFoundException;
import ru.yapridu.aptbooking.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceOld {
    @Autowired
    private final CompanyRepository repository;

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Company findById (UUID id) {
        Optional<Company> companyFromDb = repository.findById(id);
        if (companyFromDb.isPresent()) {
            return companyFromDb.get();
        } else throw new CompanyNotFoundException("Company with id "+ id +" was not found.");
    }

    public Company createNewCompany(Company newCompany) {
        return repository.save(newCompany);
    }

    public Company update(Company company) {
        return repository.save(company);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
