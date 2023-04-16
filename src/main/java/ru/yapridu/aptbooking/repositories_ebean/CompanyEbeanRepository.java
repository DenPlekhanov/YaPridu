package ru.yapridu.aptbooking.repositories_ebean;

import io.ebean.DB;
import io.ebean.Database;
import io.ebean.Query;
import org.springframework.stereotype.Repository;
import ru.yapridu.aptbooking.business_logic.entities.Company;

import java.util.List;

@Repository
public class CompanyEbeanRepository {

    public Company insert(Company company) {

        Database database = DB.getDefault();
        database.insert(company);

        return company;
    }

    public List<Company> findAll() {

        Database database = DB.getDefault();
        Query<Company> query = database.find(Company.class);
        return query
            .findList();
    }

}
