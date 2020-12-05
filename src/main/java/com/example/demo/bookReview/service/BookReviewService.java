package com.example.demo.bookReview.service;


import com.example.demo.bookReview.domain.BookReview;
import com.example.demo.bookReview.domain.BookReviewRepository;
import com.example.demo.bookReview.domain.Writer;
import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BookReviewService {

    private final UserRepository userRepository;
    private final BookReviewRepository bookReviewRepository;




    @Transactional
    public void makeBookReview(String title,
                               String bookAuthor,
                               String contents,
                               Long id) {
        User user = userRepository.findUserById(id);
        Writer writer = new Writer(user.getId(), user.getUserId(), user.getNickName());
        BookReview bookReview = new BookReview(title, bookAuthor, contents, writer);
        bookReviewRepository.save(bookReview);

    }


    @Transactional
    public BookReview findBookReview(String title) {
        BookReview bookReview = bookReviewRepository.findByTitle(title, false);
        return bookReview;
    }

    public void modifyBookReview(String title, String contents, String author, Long id ) {
        BookReview bookReview = bookReviewRepository.findById(id, false);
        bookReview.
    }

    @Transactional
    public void deleteBookReview(Long id) {
        BookReview bookReview = bookReviewRepository.findById(id, false);
        bookReview.delete();
    }
}
