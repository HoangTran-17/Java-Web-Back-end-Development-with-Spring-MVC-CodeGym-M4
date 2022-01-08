package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable) throws Exception;

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    Page<Customer> findAllByFirstNameContainingOrLastNameContaining(String f, String l);

    Customer saveAndGet(Customer customer);
}

