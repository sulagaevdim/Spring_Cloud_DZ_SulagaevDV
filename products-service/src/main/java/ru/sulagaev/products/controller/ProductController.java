package ru.sulagaev.products.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sulagaev.products.model.Product;
import ru.sulagaev.products.service.ProductService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
    public Product save(@RequestBody Product product) throws IOException, InterruptedException {
        Product product1 = service.addProduct(product);
        sendData(findAll());
        return product1;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws IOException, InterruptedException {
        service.delProduct(id);
        sendData(findAll());
        return "Продукт удален";
    }

    //отправка актуального списка товаров в сервисы "корзина" и "отзывы"
    private void sendData(List<Product> productList) throws IOException, InterruptedException {
        System.out.println("запуск метода");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/cart"))
                .POST(HttpRequest.BodyPublishers.ofString(productList.toString()))
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

}
