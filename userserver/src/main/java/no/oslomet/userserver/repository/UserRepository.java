package no.oslomet.userserver.repository;

import no.oslomet.userserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findUserByEmail(String email);
}
