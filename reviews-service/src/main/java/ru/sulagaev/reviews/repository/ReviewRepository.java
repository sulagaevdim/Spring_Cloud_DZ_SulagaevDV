package ru.sulagaev.reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sulagaev.reviews.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
