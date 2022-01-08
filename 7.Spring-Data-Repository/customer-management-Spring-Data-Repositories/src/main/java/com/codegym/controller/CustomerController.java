package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

//  @ModelAttribyte("provinces") là cách để gắn danh sách provinces vào tất cả các model của view, có thể sử dụng ở phần view.
//    @ModelAttribute("provinces")
//    public Iterable<Province> provinces(){
//        return provinceService.findAll();
//    }


    @GetMapping("/customers/searchByAll")
    public ModelAndView searchByAll(@RequestParam String keySearch) {
        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        keySearch = "%" + keySearch + "%";
        Page<Customer> customers = customerService.findAllByFirstNameContainingOrLastNameContaining(keySearch,keySearch);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(@RequestParam Optional<String> search, @PageableDefault(size = 10) Pageable pageable) {

        Page<Customer> customerList;
        if (search.isPresent()) {
            customerList = customerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            System.out.println(pageable.getPageSize());
            customerList = customerService.findAll(pageable);
        }
        return new ModelAndView("/customer/list", "customers", customerList);
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
        customer.setId((long) (Math.random() *1000));
        Customer customerNew = customerService.saveAndGet(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create","message", "New customer created successfully!" );
        modelAndView.addObject("customer", new Customer());

        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer.get());
            modelAndView.addObject("provinces", provinceService.findAll());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
}

