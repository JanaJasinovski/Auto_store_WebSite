package com.auto_store.auto_store.repository;

import com.auto_store.auto_store.enums.ERole;
import com.auto_store.auto_store.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
