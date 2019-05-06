package no.oslomet.userserver.controller;

import no.oslomet.userserver.model.User;
import no.oslomet.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(){
        return "This is a rest controller  ";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);

    }

    @GetMapping("/users/email/{email}")
    public Optional<User> findUserByEmail(@PathVariable("email") String email){
        return userService.findUserByEmail(email);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
    }

    @PostMapping("/users")
    public User saveUser( @RequestBody User newUser){
        if(userService.findUserByEmail(newUser.getEmail()).isPresent()){ return null;}
        return userService.saveUser(newUser);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable long id,  @RequestBody  User newUser){
        newUser.setId(id);
        return userService.saveUser(newUser);
    }


}
