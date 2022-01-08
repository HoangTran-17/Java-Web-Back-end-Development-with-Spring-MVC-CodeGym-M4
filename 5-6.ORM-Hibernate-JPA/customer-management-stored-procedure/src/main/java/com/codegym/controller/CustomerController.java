package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

//    @GetMapping("/customers")
//    public ModelAndView listCustomers() {
//        List<Customer> customerList = customerService.findAll();
//        return new ModelAndView("/customer/list","customers",customerList);
//    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/customer/create", "customer", new Customer());
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
//        customer.setId((long) (Math.random() *1000));
        customerService.insertWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create","message", "New customer created successfully!" );
//        modelAndView.addObject("customer", new Customer());

        return modelAndView;
    }




}

