package com.example.demo.bookReview.controller;


import com.example.demo.bookReview.domain.BookReview;
import com.example.demo.bookReview.service.BookReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookReviewController {
    private final BookReviewService bookReviewService;



    @PostMapping()
    public void makeBookReview(@RequestParam String title,
                               @RequestParam String bookAuthor,
                               @RequestParam String contents,
                               @PathVariable Long id){
        bookReviewService.makeBookReview(title, bookAuthor, contents, id);

    }

    @GetMapping()
    public BookReview findBookReview(@RequestParam String title){
        bookReviewService.findBookReview(title);

    }

    @DeleteMapping()
    public void deleteBookReview(){
        bookReviewService.deleteBookReview();
    }
}
