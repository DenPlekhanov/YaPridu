package ru.yapridu.aptbooking;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
@OpenAPIDefinition (info = @Info(title = "YaPridu API", version = "1"))
public class AptBooking {
    public static void main(String[] args) {

//        DatabaseConfig cfg = new DatabaseConfig();
//        cfg.setDefaultServer(true);
//        Properties properties = new Properties();
//        properties.put("ebean.db.ddl.generate", "true");
//        properties.put("ebean.db.ddl.run", "true");
////        properties.put("datasource.db.username", "mike");
////        properties.put("datasource.db.password", "1");
////        properties.put("datasource.db.databaseUrl", "jdbc:postgresql://localhost:5432/appointment");
////        properties.put("datasource.db.databaseDriver", "org.postgresql.Driver");
//        cfg.loadFromProperties(properties);
//        Database server = DatabaseFactory.create(cfg);

        SpringApplication.run(AptBooking.class, args);
    }
}
