package ru.yapridu.aptbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.model.entity.Company;
import ru.yapridu.aptbooking.model.exception.CompanyNotFoundException;
import ru.yapridu.aptbooking.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
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