package ru.yapridu.aptbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yapridu.aptbooking.model.entity.UserOld;

@Repository
public interface UserRepository extends JpaRepository<UserOld, Long> {
}
