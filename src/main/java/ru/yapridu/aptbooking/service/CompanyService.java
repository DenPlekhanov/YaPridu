package ru.yapridu.aptbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.model.entity.Company;
import ru.yapridu.aptbooking.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository repository;

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Optional<Company> findById (UUID id) {
        return repository.findById(id);
    }

    public Company createNewCompany(Company newCompany) {
        return repository.save(newCompany);
    }

    public void update(Company company) {
        repository.save(company);
        repository.flush();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }


}
