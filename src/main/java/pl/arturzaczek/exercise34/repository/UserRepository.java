package pl.arturzaczek.exercise34.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arturzaczek.exercise34.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> getUserEntityByEmail(String emial);
}
