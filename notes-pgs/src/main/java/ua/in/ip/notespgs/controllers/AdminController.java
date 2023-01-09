package ua.in.ip.notespgs.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.in.ip.notespgs.entityes.Role;
import ua.in.ip.notespgs.entityes.User;
import ua.in.ip.notespgs.services.UserService;

import java.security.Principal;
import java.util.Map;

@Controller
//@RestController
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("/admin")

public class AdminController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String admin(Model model, Principal principal){
        model.addAttribute("users", userService.list());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
//        model.addAttribute("roles", userService. getUserByPrincipa(principal));
        return "admin/admin";
    }

    @PostMapping("/user/ban/{id}")
    public String userBanP(@PathVariable("id") Long id){
        userService.banUser(id);
        return "redirect:/admin";
    }
    @GetMapping("/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id){
        userService.banUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user/edit/{username}")
    public String userEdit(@PathVariable("username") String username, Model model, Principal principal){
        //        model.addAttribute("user", user);
        model.addAttribute("user", userService.findByUsername(username));
//        model.addAttribute("roles", Role.values());
        return "user/user-edit";
    }

    @PostMapping("/admin/user/edit")
    public String userEdit(@RequestParam("userId") User user, @RequestParam Map<String, String> form){
//        userService.changeUserRoles(user, form);
        return "redirect:/admin";
    }

}
