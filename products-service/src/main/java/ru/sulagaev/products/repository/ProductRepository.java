package ru.sulagaev.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sulagaev.products.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
