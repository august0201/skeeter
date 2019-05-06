package no.oslomet.skeetserver.service;

import no.oslomet.skeetserver.model.Skeet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkeetService {
    List<Skeet> getAllSkeets();
    Skeet getSkeetById(Long id);
    Skeet saveSkeet(Skeet skeet);
    void deleteSkeetById(Long id);
    List<Skeet> getAllSkeetsFromUser(Long userId);

}
