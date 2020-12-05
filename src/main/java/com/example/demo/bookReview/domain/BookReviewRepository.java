package com.example.demo.bookReview.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

    BookReview findById(Long id, boolean flag);

    BookReview findByTitle(String title, boolean flag );
}
