package no.oslomet.skeetserver.service;

import no.oslomet.skeetserver.model.Skeet;
import no.oslomet.skeetserver.repository.SkeetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkeetServiceImplemented implements SkeetService{

    @Autowired
    private SkeetRepository skeetRepository;

    public List<Skeet> getAllSkeets(){return skeetRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));}

    public Skeet getSkeetById(Long id){return skeetRepository.findById(id).get();}

    public Skeet saveSkeet(Skeet skeet){return skeetRepository.save(skeet); }

    public void deleteSkeetById(Long id){skeetRepository.deleteById(id);}

    public List<Skeet> getAllSkeetsFromUser(Long userId) { return skeetRepository.findSkeetsByUserId(userId, Sort.by(Sort.Direction.DESC, "date")); }

}
