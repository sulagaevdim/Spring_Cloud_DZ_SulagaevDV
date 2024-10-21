package ru.sulagaev.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sulagaev.products.model.Product;
import ru.sulagaev.products.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<Product> findAll(){
        return service.findAll();
    }
    @PostMapping
    public Product save(@RequestBody Product product){
        return service.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delProduct(id);
        return "Продукт удален";
    }
}
