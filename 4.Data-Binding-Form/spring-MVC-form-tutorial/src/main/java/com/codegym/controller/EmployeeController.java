package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/showForm")
    public String showForm(ModelMap modelMap) {
        modelMap.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/addEmployee")
    public ModelAndView addEmployee(@ModelAttribute Employee employee) {
        ModelAndView modelAndView = new ModelAndView("employee/info");
        modelAndView.addObject("employee", employee);
//        modelAndView.addObject("name", employee.getName());
//        modelAndView.addObject( "contactNumber",employee.getContactNumber());
//        modelAndView.addObject("id", employee.getId());
        return modelAndView;
    }
}

