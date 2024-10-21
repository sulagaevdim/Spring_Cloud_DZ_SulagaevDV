package ru.sulagaev.cart_service.model;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.sulagaev.products.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Cart {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }
    public void delProduct(int id){
        productList.remove(id);
    }
}
