package com.example.demo.bookReview.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chapter")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Embedded
    private Writer writer;

    private String contents;

    public Chapter(Writer writer, String contents, String mainPoint, String questions) {
        this.writer = writer;
        this.contents = contents;
        this.mainPoint = mainPoint;
        this.questions = questions;
        this.wrtTime = LocalDateTime.now();
    }

    private String mainPoint;
    private String questions;

    private LocalDateTime wrtTime;

    public Chapter() {

    }
}
