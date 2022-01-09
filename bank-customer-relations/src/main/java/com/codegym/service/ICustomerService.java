package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    Customer save(Customer customer);

    Optional<Customer> findById(int customerId);

    void remove(int customerID);
}

