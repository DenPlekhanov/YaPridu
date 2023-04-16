package ru.yapridu.aptbooking.repositories_ebean;

import io.ebean.DB;
import io.ebean.Database;
import org.springframework.stereotype.Repository;
import ru.yapridu.aptbooking.business_logic.entities.Company;

@Repository
public class CompanyEbeanRepository {

    public Company insert(Company company) {

        Database server = DB.getDefault();
        server.insert(company);

        return company;
    }

}
