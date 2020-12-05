package com.example.demo.user.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // code
    private Long id;




    private String userId; // email
    private String password;

    private String nickName;

    public User(String userId, String password, String nickName) {
        this.userId = userId;
        this.password = password;
        this.nickName = nickName;
    }

    public static User createUser(String userId,
                                  String password,
                                  String nickName){
        return new User(userId, password,  nickName);
    }

    public User() {

    }
}
