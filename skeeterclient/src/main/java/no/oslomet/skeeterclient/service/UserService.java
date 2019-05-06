package no.oslomet.skeeterclient.service;

import no.oslomet.skeeterclient.model.User;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    String BASE_URL = "http://104.248.36.117:9090/users";
    private RestTemplate restTemplate = new RestTemplate();

    public List<User> getUsers(){
        return  Arrays.stream(
                restTemplate.getForObject(BASE_URL, User[].class)
        ).collect(Collectors.toList());
    }

    public User getUserById(long id){
        User user = restTemplate.getForObject(BASE_URL+"/"+id, User.class);
        return user;
    }

    public Optional<User> findUserByEmail(String email){
        Optional<User> user = Optional.of(restTemplate.getForObject(BASE_URL+"/email/"+email, User.class));
        return user;
    }

  //Kan brukes om det du prøver ikke funker


    /*public Optional<User> findUserByEmail(String email){
        for(User user : getUsers()){
            if(user.getEmail().equals(email)){
                return Optional.of(user);
            }

        } return null;
    }*/

    public User saveUser(User newUser){
        return restTemplate.postForObject(BASE_URL, newUser, User.class);
    }

    public void updateUser(long id, User updatedUser){
        restTemplate.put(BASE_URL+"/"+id, updatedUser);
    }

    public void deleteUserById(long id){
        restTemplate.delete(BASE_URL+"/"+id);
    }

}
