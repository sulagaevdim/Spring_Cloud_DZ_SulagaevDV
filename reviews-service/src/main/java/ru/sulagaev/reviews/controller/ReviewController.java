package ru.sulagaev.reviews.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sulagaev.reviews.model.Review;
import ru.sulagaev.reviews.service.ReviewService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService service;

    @GetMapping
    public List<Review> findAll(){
        return service.findAll();
    }

    @PostMapping("{nameProduct}")
    public Review addProductForReviewing(@PathVariable String nameProduct){
        return service.saveReview(nameProduct);
    }
}
