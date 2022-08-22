package ru.kata.spring.boot_security.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Model.User;
import ru.kata.spring.boot_security.demo.Service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping()
    public String userList(Model model, Principal principal) {
        model.addAttribute("user", userService.allUsers());
        model.addAttribute("admin", userService.findUserByName(principal.getName()));
        model.addAttribute("roles", userService.listRoles());
        model.addAttribute("newUser", new User());
        return "/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/create")
    public String creatUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", userService.listRoles());

        return "/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/{id}/update")
    public String updateUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("roles", userService.listRoles());
       return "/update";

    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }


}
