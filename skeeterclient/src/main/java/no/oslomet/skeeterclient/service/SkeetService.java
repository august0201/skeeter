package no.oslomet.skeeterclient.service;

import no.oslomet.skeeterclient.model.Skeet;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkeetService {

    String BASE_URL = "http://104.248.36.117:9091/skeets";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Skeet> getSkeets(){
        return  Arrays.stream(
                restTemplate.getForObject(BASE_URL, Skeet[].class)
        ).collect(Collectors.toList());
    }

    public Skeet getSkeetById(long id){
        Skeet skeet = restTemplate.getForObject(BASE_URL+"/"+id, Skeet.class);
        return skeet;
    }

    public List<Skeet> getAllByUserId(Long userId){
        return Arrays.stream(restTemplate.getForObject(BASE_URL+"/temp/"+userId, Skeet[].class)
        ).collect(Collectors.toList());
    }

    public Skeet saveSkeet(Skeet newSkeet){
        return restTemplate.postForObject(BASE_URL, newSkeet, Skeet.class);
    }

    public void updateSkeet(long id, Skeet updatedSkeet){
        restTemplate.put(BASE_URL+"/"+id, updatedSkeet);
    }

    public void deleteSkeetById(long id){
        restTemplate.delete(BASE_URL+"/"+id);
    }
}
