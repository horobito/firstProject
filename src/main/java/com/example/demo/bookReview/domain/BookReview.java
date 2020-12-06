package com.example.demo.bookReview.domain;


import com.example.demo.log.service.LastBookReview;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor
public class BookReview extends AbstractAggregateRoot<BookReview> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String bookAuthor;
    private String contents;

    public BookReview(String title, String bookAuthor, String contents, Writer writer) {
        this.title = title;
        this.bookAuthor = bookAuthor;
        this.contents = contents;
        this.writer = writer;
        this.wrtTime = LocalDateTime.now();
    }

    public BookReview(String title, String bookAuthor, String contents) {
        this.title = title;
        this.bookAuthor = bookAuthor;
        this.contents = contents;
        this.wrtTime = LocalDateTime.now();
    }



    @Embedded
    private Writer writer;


    private LocalDateTime wrtTime;
    private LocalDateTime updateTime;




    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("post")
    private List<Chapter> chapters;

    private boolean flag;



    public void delete(){
        this.flag = true;
    }


    public static BookReview createBookReview(String title,
                                       String bookAuthor,
                                       String contents,
                                       Writer writer){
        return new BookReview(title, bookAuthor, contents, writer);
    }

    public static BookReview createUpdatedBookReview(String title,
                                                     String bookAuthor,
                                                     String contents){
        return new BookReview(title, bookAuthor, contents);
    }


    public void update(LastBookReview lastBookReview, BookReview updatedBookReview) {
        this.title = updatedBookReview.getTitle();
        this.contents = updatedBookReview.getContents();
        this.bookAuthor = updatedBookReview.getBookAuthor();

        Event event = Event.createEvent(
                this,
                lastBookReview,
                updatedBookReview.getTitle(),
                updatedBookReview.getContents(),
                updatedBookReview.getBookAuthor()
        );

        registerEvent(event);


    }
}
