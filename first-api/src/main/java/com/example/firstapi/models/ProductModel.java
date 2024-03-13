package com.example.firstapi.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable {
    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private BigDecimal price;

    public UUID getIdProduct() {
        return id;
    }

    public void setIdProduct(UUID idProduct) {
        this.id = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
