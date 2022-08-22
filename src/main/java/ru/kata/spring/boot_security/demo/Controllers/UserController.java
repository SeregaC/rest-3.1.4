package ru.kata.spring.boot_security.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.Service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping()
    public String pageUser(Principal principal, Model model) {
        model.addAttribute("user", userService.findUserByName(principal.getName()));

        return "/user";
    }

    @GetMapping("/{id}")
    public String pageUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("roles", userService.listRoles());
        model.addAttribute("user", userService.findUserById(id));
        return "/user";
    }

}
