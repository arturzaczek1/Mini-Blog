package pl.arturzaczek.exercise34.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arturzaczek.exercise34.entity.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
    Optional<Role> findByRoleName(String roleName);
}
