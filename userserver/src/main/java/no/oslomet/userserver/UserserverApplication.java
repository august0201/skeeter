package no.oslomet.userserver;

import no.oslomet.userserver.model.User;
import no.oslomet.userserver.repository.UserRepository;
import no.oslomet.userserver.service.UserServiceImplemented;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserserverApplication{


    public static void main(String[] args) {
        SpringApplication.run(UserserverApplication.class, args);
    }


}
