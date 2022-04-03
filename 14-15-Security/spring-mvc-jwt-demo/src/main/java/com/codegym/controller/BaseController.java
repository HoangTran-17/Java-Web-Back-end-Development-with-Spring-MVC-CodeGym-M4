package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
    @RequestMapping(value = {"/login", "/"})
    public ModelAndView login(@RequestParam(value = "error", required = false) final String error, final ModelAndView modelAndView) {
        if (error != null) {
            modelAndView.addObject("message", "Login Failed!");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
    @RequestMapping("/logout")
    public ModelAndView logout(final ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        modelAndView.addObject("message", "Logged out!");
        return modelAndView;
    }

}

