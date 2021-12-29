package com.example.b1_form_register.controller;

import com.example.b1_form_register.model.User;
import com.example.b1_form_register.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String displayCreate(Model model) {
        model.addAttribute("user", new User());
        return "/index";
    }
    @PostMapping("/user")
    public String result(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/index";
        }
        userService.save(user);
        return "/result";
    }
}
