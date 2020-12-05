package com.example.demo.bookReview.domain;


import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Embeddable
@NoArgsConstructor
public class Writer {

    @Column(name = "writer_id")
    private Long id;

    @Column(name = "writer_name")
    private String writerName;

    @Column(name = "writer_nickname")
    private String writerNickName;

    public Writer(Long id, String writerName,String writerNickName) {
        this.id = id;
        this.writerName = writerName;
        this.writerNickName = writerNickName;
    }
}
