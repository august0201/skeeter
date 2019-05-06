package no.oslomet.userserver.service;

import no.oslomet.userserver.model.User;
import no.oslomet.userserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplemented implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){return userRepository.findAll();}

    public User getUserById(Long id){return userRepository.findById(id).get();}

    public User saveUser(User user){ return userRepository.save(user);}

    public void deleteUserById(Long id){userRepository.deleteById(id);}

    public Optional<User> findUserByEmail(String email){return userRepository.findUserByEmail(email);}
}
