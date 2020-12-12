package com.example.demo.bookReview.domain;


import com.example.demo.log.service.LastBookReview;
import lombok.Getter;

@Getter
public class Event {

    private BookReview changedBookReview;

    private String preTitle;
    private String updatedTitle;

    private String preContents;
    private String updatedContents;

    private String preBookAuthor;
    private String updatedBookAuthor;

    public Event(BookReview updatedPost,
                 LastBookReview lastBookReview,
                 String title,
                 String contents,
                 String author) {
        this.changedBookReview = updatedPost;
        this.preTitle = lastBookReview.getPreTitle();
        this.updatedTitle = title;

        this.preContents = lastBookReview.getPreContent();
        this.updatedContents = contents;

        this.preBookAuthor = lastBookReview.getPreBookAuthor();
        this.updatedBookAuthor = author;

    }

    public static Event createEvent(BookReview updatedBookReview,
                                    LastBookReview lastBookReview,
                                    String title,
                                    String contents,
                                    String author){
        return new Event(updatedBookReview, lastBookReview, title, contents, author);
    }
}
