package ru.yapridu.aptbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.model.entity.CompanyOld;
import ru.yapridu.aptbooking.model.exception.CompanyNotFoundException;
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

    public List<CompanyOld> findAll() {
        return repository.findAll();
    }

    public CompanyOld findById (UUID id) {
        Optional<CompanyOld> companyFromDb = repository.findById(id);
        if (companyFromDb.isPresent()) {
            return companyFromDb.get();
        } else throw new CompanyNotFoundException("Company with id "+ id +" was not found.");
    }

    public CompanyOld createNewCompany(CompanyOld newCompany) {
        return repository.save(newCompany);
    }

    public CompanyOld update(CompanyOld company) {
        return repository.save(company);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
