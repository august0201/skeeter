package no.oslomet.skeeterclient.controller;

import no.oslomet.skeeterclient.model.Skeet;
import no.oslomet.skeeterclient.model.User;
import no.oslomet.skeeterclient.service.SkeetService;
import no.oslomet.skeeterclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private SkeetService skeetService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({"/", "/index"})
    public String index(Model model){

        model.addAttribute("skeets", skeetService.getSkeets());
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return"login";
    }

    @GetMapping("/home")
    public String homePage(Model model ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userService.findUserByEmail(auth.getName());
        if(user.isPresent()) model.addAttribute("user", user.get());
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("skeets", skeetService.getSkeets());
        return "index";
    }
    @GetMapping("/friendsSkeets")
    public String friendsSkeets(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userService.findUserByEmail(auth.getName());
        model.addAttribute("user", user.get());
        model.addAttribute("users", userService.getUsers());

        List<Skeet> skeets = new ArrayList<>();
        for(Long i : user.get().getFollowing()){
            skeets.addAll(skeetService.getAllByUserId(i));
        }
        System.out.println(skeets.toString());
        model.addAttribute("skeets", skeets);
        return "index";
    }

    @GetMapping("/yourSkeets")
    public String yourSkeets(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName()).get();

        model.addAttribute("user", user);
        model.addAttribute("users", userService.getUsers());

        List<Skeet> skeets = skeetService.getAllByUserId(user.getId());

        model.addAttribute("skeets", skeets);

        return "index";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("usr") User user){
        System.out.println(user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        System.out.println("user to save: " + user);
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/postSkeet")
    public String postSkeet(@ModelAttribute("skeet") Skeet skeet){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName()).get();
        skeet.setUserId(user.getId());
        skeet.setDate(LocalDateTime.now());
        skeetService.saveSkeet(skeet);
        System.out.println(skeet.toString());

        return "redirect:/home";
    }

    @GetMapping("/deleteSkeet/{id}")
    public String deleteSkeet(@PathVariable("id") Long id){
        skeetService.deleteSkeetById(id);
        return "redirect:/home";
    }



}
