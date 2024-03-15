package com.example.auth.controllers;

import com.example.auth.domain.dtos.ProductDTO;
import com.example.auth.domain.entities.product.Product;
import com.example.auth.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity createProduct (@RequestBody @Validated ProductDTO data) throws Exception {
        Product newProduct = productService.createProduct(data);

        return new ResponseEntity(newProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productService.getAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
