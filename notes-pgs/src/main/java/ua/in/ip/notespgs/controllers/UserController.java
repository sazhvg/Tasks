package ua.in.ip.notespgs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.in.ip.notespgs.entityes.User;
import ua.in.ip.notespgs.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/login")
//    public String login(Principal principal, Model model){
//        model.addAttribute("user", userService.getUserByPrincipal(principal));
//        return "login";
//    }

//    @GetMapping("/profile")
//    public String profile(Principal principal, Model model) {
//        User user = userService.getUserByPrincipal(principal);
//        model.addAttribute("user", user);
//        return "profile";
//    }
//
    @GetMapping("/registration")
    public String registration(Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("createMessage",
                "Користувач: " + userService.getUserByPrincipal(principal).getUsername() + " зареєстровано та потребує активації.");
        return "user/registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)){
            model.addAttribute("errorMessage", "Користувач: " + user.getUsername() + " вже існує.");
//            return "registration";
        }
        return "redirect:/admin";
    }

//    @GetMapping("/user/{user}")
//    public String userInfo(@PathVariable("user") User user, Model model, Principal principal){
//        model.addAttribute("user", user);
//        model.addAttribute("userByPrincipal", userService.getUserByPrincipal(principal));
//        model.addAttribute("products", user.getProducts());
//        return  "user-info";
//    }
}
