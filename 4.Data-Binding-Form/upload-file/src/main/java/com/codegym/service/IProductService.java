package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findID(int id);

    void update(int id, Product product);

    void remote(int id);

}
