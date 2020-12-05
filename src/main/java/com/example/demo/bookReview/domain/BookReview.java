package com.example.demo.bookReview.domain;


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

    @Embedded
    private Writer writer;


    private LocalDateTime wrtTime;
    private LocalDateTime updateTime;




    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("post")
    private List<Chapter> chapters;

    private boolean flag;


    public BookReview() {

    }
}
