package ru.crudtoboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.crudtoboot.springboot.model.User;
import ru.crudtoboot.springboot.service.UserService;


@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getIndex(ModelMap model) {
        model.addAttribute("users", userService.getAllUser());
        return "UsersList";
    }

    @GetMapping("/UsersAdd")
    public String addForm(ModelMap model) {
        model.addAttribute("users", new User());
        return "UserAdd";
    }

    @PostMapping(value = "/UserAdd")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "UserEdit";
    }

    @PatchMapping(value = "/edit")
    public String editSubmit(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }


}

