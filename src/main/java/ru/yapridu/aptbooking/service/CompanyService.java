package ru.yapridu.aptbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.model.Company;
import ru.yapridu.aptbooking.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository repository;

    public List<Company> getAll() {
        return repository.findAll();
    }

    public Company createNewCompany(Company newCompany) {
        return repository.save(newCompany);
    }
}
