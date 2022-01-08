package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findID(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        for (Product p: productList) {
            if (p.getId() == id) {
                p = product;
                break;
            }
        }
    }

    @Override
    public void remote(int id) {
        for (Product p: productList) {
            if (p.getId() == id) {
                productList.remove(p);
                break;
            }
        }
    }
}
