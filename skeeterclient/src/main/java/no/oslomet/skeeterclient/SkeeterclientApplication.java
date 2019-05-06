package no.oslomet.skeeterclient;

import no.oslomet.skeeterclient.model.Skeet;
import no.oslomet.skeeterclient.model.User;
import no.oslomet.skeeterclient.service.SkeetService;
import no.oslomet.skeeterclient.service.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SkeeterclientApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private SkeetService skeetService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SkeeterclientApplication.class, args);
    }

    @Override
    public void run(String[] args){
        userService.saveUser(new User("August", "Reinholt", "august0201", "august.reinholt@gmail.com", passwordEncoder.encode("test"), "image", "ADMIN", new ArrayList<Long>(Arrays.asList(2L, 3L)), new ArrayList<Long>(Arrays.asList(2L,3L))));
        userService.saveUser(new User("Kim", "Torp", "kimmyboii", "kim@gmail.com", passwordEncoder.encode("test"), "image", "USER", new ArrayList<Long>(Arrays.asList(1L,5L)), new ArrayList<Long>(Arrays.asList(1L,5L))));
        userService.saveUser(new User("Øyvind", "Mjelstad", "mjelstad91", "mjelstad@gmail.com", passwordEncoder.encode("test"), "image", "USER", new ArrayList<>(), new ArrayList<>()));
        userService.saveUser(new User("Tore", "Tang", "gammalmann", "tore@gmail.com", passwordEncoder.encode("test"), "image", "USER", new ArrayList<>(), new ArrayList<>()));
        userService.saveUser(new User("Varg", "Veum", "wolfieboy", "varg@gmail.com", passwordEncoder.encode("test"), "image", "USER", new ArrayList<>(), new ArrayList<>()));
        skeetService.saveSkeet(new Skeet("Eg elsker Billie Eilish!", LocalDateTime.now(), 2L, null));
        skeetService.saveSkeet(new Skeet("Wow, har dere sett den nyeste Revengers-filemn?", LocalDateTime.now(), 1L, "https://i.kym-cdn.com/photos/images/newsfeed/001/367/055/724.png"));
        skeetService.saveSkeet(new Skeet("Subscribe to t-series", LocalDateTime.now(), 1L, null));
        skeetService.saveSkeet(new Skeet("Hvorfor har aldri Donald Glover på seg skjorte??", LocalDateTime.now(), 4L, "https://dancingastronaut.com/wp-content/uploads/2019/04/childish-gambino-guava-island-teaser-1554477193-1.jpg"));
        skeetService.saveSkeet(new Skeet("Skriver bachelor da", LocalDateTime.now(), 3L, "https://pics.me.me/average-day-as-a-programmer-how-i-thought-it-would-21574243.png"));
        skeetService.saveSkeet(new Skeet("Hey, what's up. Wolfieboy her ;)", LocalDateTime.now(), 5L, null));
        skeetService.saveSkeet(new Skeet("Begynner å bli lei av gammelt brød", LocalDateTime.now(), 4L, null));
        skeetService.saveSkeet(new Skeet("Hehehe", LocalDateTime.now(), 1L, "https://i.imgur.com/4W9knZC.jpg"));
        skeetService.saveSkeet(new Skeet("De døde har det godt", LocalDateTime.now(), 5L, null));
        skeetService.saveSkeet(new Skeet("Sjekk ut bandet mitt Hysj", LocalDateTime.now(), 2L, "https://i.ytimg.com/vi/9oDto_PLjDk/hqdefault.jpg"));
    }

}
