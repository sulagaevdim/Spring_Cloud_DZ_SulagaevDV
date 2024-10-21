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
        sendAddingData(product);
        return product1;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws IOException, InterruptedException {
        service.delProduct(id);
        sendDeletingData(id);
        return "Товар удален";
    }

    //отправка актуального списка товаров в сервисы "корзина" и "отзывы"
    private void sendAddingData(Product product) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/cart"))
                .POST(HttpRequest.BodyPublishers.ofString(product.getName() + ":" + product.getPrice()))
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        System.out.println("Запрос в МС -Корзина- отправлен");
        request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8083/reviews/" + product.getName()))
                .POST(HttpRequest.BodyPublishers.noBody()).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        System.out.println("Запрос в МС -Отзывы- отправлен");

    }
    private void sendDeletingData(Long id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/cart/" + id))
                .DELETE().build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.print(response.body());
        System.out.println("Запрос в МС Корзина отправлен");
    }

}
