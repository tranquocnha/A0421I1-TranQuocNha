package com.example.cesutudy.controller;

import com.example.cesutudy.model.User;
import com.example.cesutudy.repository.user.UserRepository;
import com.example.cesutudy.service.common.BCryptPassword;
import com.example.cesutudy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepo;
    @Autowired
    BCryptPassword bCryptPassword;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        User user = userService.findByName(principal.getName());
        model.addAttribute("user", user);
        System.out.println(user.getEmployee().getEmployeeName());
        return "adminPage";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
//            User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//            String userInfo = WebUtils.toString(loginedUser);
//
//            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }
}
