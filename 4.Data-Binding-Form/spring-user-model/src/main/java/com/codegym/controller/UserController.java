package com.codegym.controller;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("/login", "login",new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute Login login) {
        User user = UserService.checkLogin(login);
        if (user == null) {
            return new ModelAndView("/login","message","Login error!");
        }
        return new ModelAndView("/user","user",user);
    }
}

