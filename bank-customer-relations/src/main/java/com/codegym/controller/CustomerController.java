package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ModelAndView listCustomer(@PageableDefault(size = 10)Pageable pageable) {
        Page<Customer> customerList = customerService.findAll(pageable);
        return new ModelAndView("/customers/list","customerList",customerList);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customers/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
        customer.setCustomerID( (int) (Math.random() *1000));
        customer.setCurrentBalance((double) 0);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customers/create","message", "New customer created successfully!" );
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customers/edit");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer) {
        Customer newCustomer = customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customers/edit");
        modelAndView.addObject("customer", newCustomer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customers/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getCustomerID());
        ModelAndView modelAndView = new ModelAndView("/customers/delete");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer suspended successfully!");
        return modelAndView;    }
}
