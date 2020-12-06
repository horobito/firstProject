package com.example.demo.log.service;

import com.example.demo.bookReview.domain.BookReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;


@Value
@Getter
@AllArgsConstructor
public class LastBookReview {
    BookReview bookReview;
    String preTitle;
    String preContent;
    String preBookAuthor;

    public LastBookReview(BookReview bookReview) {
        this.bookReview = bookReview;
        this.preTitle = bookReview.getTitle();
        this.preContent = bookReview.getContents();
        this.preBookAuthor = bookReview.getBookAuthor();
    }



    public static LastBookReview createLastBookReview(BookReview bookReview) {
        return new LastBookReview(bookReview);

    }
}
