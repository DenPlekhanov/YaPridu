package ru.yapridu.aptbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yapridu.aptbooking.business_logic.entities.UserOld;

@Repository
public interface UserRepository extends JpaRepository<UserOld, Long> {
}
