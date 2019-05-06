package no.oslomet.skeeterclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class User {

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
