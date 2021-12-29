package com.example.springweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);
}
