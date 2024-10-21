package ru.sulagaev.cart_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sulagaev.cart_service.model.Cart;
import ru.sulagaev.cart_service.repository.ProductRepository;
import ru.sulagaev.products.model.Product;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final Cart cart;
    private final ProductRepository repository;

    @PostMapping
    public void getActualListProducts(@RequestBody List<Product> productList){
        repository.setProductList(productList);
    }
    @GetMapping
    public List<Product> findAllProductsInCart(){
        return cart.getProductList();
    }

    @GetMapping("/{id}")
    public String addProductInCart(@PathVariable int id){
        try {
            cart.addProduct(repository.getProductList().get(id - 1));
            return "товар добавлен в корзину";
        }catch (IndexOutOfBoundsException e){
            return "Товара с таким id не существует";
        }
    }
    @DeleteMapping("/{id}")
    public void deleteProductFromCart(@PathVariable int id){
        cart.delProduct(id);
    }
}
