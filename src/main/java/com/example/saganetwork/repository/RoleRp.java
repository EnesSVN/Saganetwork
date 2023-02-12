package com.example.saganetwork.repository;

import com.example.saganetwork.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRp extends JpaRepository<Role, Long> {

    Role findByRoleName(String RoleName);
}
