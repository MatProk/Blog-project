package com.mateusz.app.repository;

import com.mateusz.app.domain.Role;
import com.mateusz.app.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName roleName);
}