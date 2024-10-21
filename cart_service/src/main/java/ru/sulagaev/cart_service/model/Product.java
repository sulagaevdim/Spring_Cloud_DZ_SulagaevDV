package ru.sulagaev.cart_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;

    public Product(){

    }
    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
