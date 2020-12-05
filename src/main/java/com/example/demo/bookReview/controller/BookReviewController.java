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
        return (bookReviewService.findBookReview(title));

    }

    @PostMapping
    public void ModifiyBookReview(@RequestParam String title,
                                  @RequestParam String contents,
                                  @RequestParam String author,
                                  @PathVariable Long id){
        bookReviewService.modifyBookReview(title, contents, author, id);

    }

    @DeleteMapping()
    public void deleteBookReview(@PathVariable Long id){
        bookReviewService.deleteBookReview(id);
    }
}
