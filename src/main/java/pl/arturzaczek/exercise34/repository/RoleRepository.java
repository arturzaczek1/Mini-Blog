package pl.arturzaczek.exercise34.repository;

import pl.arturzaczek.exercise34.entity.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByRoleName(String roleName);
}
