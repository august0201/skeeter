package no.oslomet.userserver.service;

import no.oslomet.userserver.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUserById(Long id);
    Optional<User> findUserByEmail(String email);
}
