package no.oslomet.skeetserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Skeet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tweet;
    private LocalDateTime date;
    private Long userId;
    private String img;

    public Skeet(String tweet, LocalDateTime date, Long userId, String img){
        this.tweet = tweet;
        this.date = date;
        this.userId = userId;
        this.img = img;
    }
}
