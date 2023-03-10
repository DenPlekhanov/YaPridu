package ru.yapridu.aptbooking.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yapridu.aptbooking.model.security.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}