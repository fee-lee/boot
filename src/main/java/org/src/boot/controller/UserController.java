package org.src.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.src.boot.model.User;
import org.src.boot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/newUser")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUsers(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/user";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteByIdUsers(id);
        return "redirect:/user";
    }
}
