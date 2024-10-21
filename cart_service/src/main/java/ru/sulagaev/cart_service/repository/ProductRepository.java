package ru.sulagaev.cart_service.repository;

import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sulagaev.products.model.Product;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
@Data
@Repository
@AllArgsConstructor
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();
}
