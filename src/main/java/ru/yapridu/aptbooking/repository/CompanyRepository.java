package ru.yapridu.aptbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yapridu.aptbooking.model.entity.CompanyOld;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyOld, UUID> {
}
