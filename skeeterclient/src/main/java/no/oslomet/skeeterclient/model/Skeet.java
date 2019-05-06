package no.oslomet.skeeterclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class Skeet {

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