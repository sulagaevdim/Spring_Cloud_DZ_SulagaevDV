package ru.sulagaev.cart_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sulagaev.cart_service.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
