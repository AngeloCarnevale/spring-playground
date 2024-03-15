package com.example.auth.services;

import com.example.auth.domain.dtos.ProductDTO;
import com.example.auth.domain.entities.product.Product;
import com.example.auth.domain.repositories.ProductRepository;
import com.example.auth.infra.exceptions.ValidatePriceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product createProduct(ProductDTO data) throws Exception {

        if(data.price().compareTo(BigDecimal.valueOf(0)) <= 0 ) {
            throw new ValidatePriceException("The price value must be positive");
        }
        Product newProduct = new Product(data);
        this.saveProduct(newProduct);
        return newProduct;
    }
    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    public void saveProduct(Product product){
        this.repository.save(product);
    }
}
