package ru.sulagaev.products.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sulagaev.products.model.Product;
import ru.sulagaev.products.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }
    public Product addProduct(Product product){
        return repository.save(product);
    }
    public void delProduct(Long id){
        repository.deleteById(id);
    }
}
