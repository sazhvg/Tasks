package ua.in.ip.notespgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.ip.notespgs.entityes.User;
import ua.in.ip.notespgs.services.UserService;

import java.security.Principal;

@RestController
public class NoteController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired

    @GetMapping("/")
    public String homePage (){
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticatedUser (/*@PathVariable Long id*/Principal principal){
        User user = userService.findByUsername(principal.getName());
        return "authenticated service " + user.getUsername() + " " + user.getEmail();
    }

    @GetMapping("/read_profile")
    public String pageForReadProfile (){
        return "read profile page ";
    }

    @GetMapping("/only_for_admins")
    public String pageOnlyForAdmins (){
        return "admins page ";
    }
}
