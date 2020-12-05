package com.example.demo.user.service;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public User findByUserIdAndPassword(String userId, String password){
        User user = userRepository.findByUserIdAndPassword(userId, password);
        return user;
    }
}
