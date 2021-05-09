package com.ducnt.foodie.service;

import com.ducnt.foodie.model.Product;
import com.ducnt.foodie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct() {
    }

    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productRepository.findAllByActive(true);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
