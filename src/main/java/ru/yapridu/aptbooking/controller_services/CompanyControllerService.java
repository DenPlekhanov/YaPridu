package ru.yapridu.aptbooking.controller_services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.business_logic.models.CreateCompanyDTO;
import ru.yapridu.aptbooking.business_logic.models.VersionedModelDTO;
import ru.yapridu.aptbooking.business_logic.services.entities.CompanyService;

@Service
@AllArgsConstructor
public class CompanyControllerService {

    private final CompanyService companyService;

    public VersionedModelDTO create(CreateCompanyDTO companyData) {

        return VersionedModelDTO.of(this.companyService.create(companyData));
    }

}