package ru.sulagaev.reviews.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private String reviews;

    public Review(){}

    public Review(String product) {
        this.product = product;
        reviews = randomReview();
        reviews += "; " + randomReview();
    }

    private String randomReview() {
        String[] randomBase = new String[]{"Хороший аппарат", "Пойдет", "Так себе",
                "Сломался через 5 секунд", "Пережил ядерную войну, класс",
                "Купил жене в рассрочку, жена ушла рассрочка осталась"};
        Random random = new Random();
        return randomBase[random.nextInt(0, 5)];
    }
}
