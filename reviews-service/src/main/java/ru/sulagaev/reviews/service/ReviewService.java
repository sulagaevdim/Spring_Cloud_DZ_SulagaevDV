package ru.sulagaev.reviews.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sulagaev.reviews.model.Review;
import ru.sulagaev.reviews.repository.ReviewRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    public final ReviewRepository repository;

    public List<Review> findAll(){
        return repository.findAll();
    }
    public Review saveReview(String name){
        return repository.save(new Review(name));
    }


}
