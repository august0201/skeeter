package no.oslomet.userserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String userImage;
    private String role;
    private ArrayList<Long> followers;
    private ArrayList<Long> following;

    public User(String firstName, String lastName, String username, String email, String password, String userImage, String role, ArrayList<Long> followers, ArrayList<Long> following){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userImage = userImage;
        this.role = role;
        this.followers = followers;
        this.following = following;
    }


}
