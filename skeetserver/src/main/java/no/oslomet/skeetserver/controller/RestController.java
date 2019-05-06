package no.oslomet.skeetserver.controller;

import no.oslomet.skeetserver.model.Skeet;
import no.oslomet.skeetserver.service.SkeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    SkeetService skeetService;

    @GetMapping("/")
    public String home(){
        return "This is a rest controller  ";
    }

    @GetMapping("/skeets")
    public List<Skeet> getAllSkeets(){
        return skeetService.getAllSkeets();
    }


    @GetMapping("/skeets/{id}")
    public Skeet getSkeetById(@PathVariable long id){
        return skeetService.getSkeetById(id);

    }

    @DeleteMapping("/skeets/{id}")
    public void deleteSkeetById(@PathVariable long id){
        skeetService.deleteSkeetById(id);
    }

    @PostMapping("/skeets")
    public Skeet saveSkeet( @RequestBody Skeet newSkeet){
        return skeetService.saveSkeet(newSkeet);
    }

    @GetMapping("/skeets/temp/{userId}")
    public List<Skeet> getAllByUserId(@PathVariable Long userId) {
        return skeetService.getAllSkeetsFromUser(userId);
    }

    @PutMapping("/skeets/{id}")
    public Skeet updateSkeet(@PathVariable long id,  @RequestBody  Skeet newSkeet){
        newSkeet.setId(id);
        return skeetService.saveSkeet(newSkeet);
    }



}
