package ru.yapridu.aptbooking.controller_services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.business_logic.entities.Company;
import ru.yapridu.aptbooking.business_logic.models.CreateOrUpdateCompanyDTO;
import ru.yapridu.aptbooking.business_logic.models.VersionedModelDTO;
import ru.yapridu.aptbooking.business_logic.services.entities.CompanyService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyControllerService {

    private final CompanyService companyService;

    public VersionedModelDTO create(CreateOrUpdateCompanyDTO companyData) {

        return VersionedModelDTO.of(this.companyService.create(companyData));
    }

    public List<Company> getAll() {

        return this.companyService.getAll();
    }

    public Company getById(UUID id){

        return this.companyService.getById(id);
    }

    public VersionedModelDTO update (UUID id, CreateOrUpdateCompanyDTO companyData) {

        return VersionedModelDTO.of(companyService.update(id , companyData));
    }

    public void deleteById (UUID id){

        this.companyService.deleteById(id);
    }
}
