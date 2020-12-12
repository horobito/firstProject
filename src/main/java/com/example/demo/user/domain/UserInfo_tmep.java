package com.example.demo.user.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

public class UserInfo_tmep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // code
    private Long id;



    @Column(name = "userId", unique = true)
    private String userId; // email

    @Column(name = "password")
    private String password;

    @Column(name = "nickName")
    private String nickName;

    @Column(name = "auth")
    private String auth;

    public UserInfo_tmep(String userId, String password, String nickName, String auth) {
        this.userId = userId;
        this.password = password;
        this.nickName = nickName;
        this.auth = auth;
    }

    public static UserInfo_tmep createUser(String userId,
                                  String password,
                                  String nickName,
                                  String auth){
        return new UserInfo_tmep(userId, password,  nickName, auth);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){

    }



}
