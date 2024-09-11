package org.security.todoapp.controller;


import org.security.todoapp.model.User;
import org.security.todoapp.service.CoustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private CoustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String redirectToLogin(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login-page";
    }

    @GetMapping("sign-up")
    public String signUp(){
        return "signup-page";
    }

    @PostMapping("/sing-up")
    public String singUp(@ModelAttribute User user){
        this.customUserDetailsService.saveUser(user);
        return "redirect:/login";
    }
}
