package ru.sulagaev.cart_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sulagaev.cart_service.model.Cart;
import ru.sulagaev.cart_service.model.Product;
import ru.sulagaev.cart_service.repository.ProductRepository;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final Cart cart;
    private final ProductRepository repository;

    @PostMapping
    public void getActualListProducts(@RequestBody String product){
        String[] split = product.split(":");
        repository.save(new Product(split[0], split[1]));
    }
    @GetMapping
    public List<Product> findAllProductsInCart(){
        return cart.getProductList();
    }

    @GetMapping("/{id}")
    public String addProductInCart(@PathVariable Long id){
        try {
            cart.addProduct(repository.findById(id).orElse(null));
            return "товар под номером " + id + " добавлен в корзину";
        }catch (NullPointerException e){
            return "товара не существует";
        }catch (IndexOutOfBoundsException e) {
            return "товара не существует";
        }

    }
    @DeleteMapping("/{id}")
    public void deleteProductFromCart(@PathVariable int id){
        cart.delProduct(id-1);
    }
}
