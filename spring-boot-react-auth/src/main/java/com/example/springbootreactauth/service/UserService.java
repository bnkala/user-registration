package com.example.springbootreactauth.service;


import com.example.springbootreactauth.model.User;

public interface UserService {
    User findByEmail(String email);
    User saveUser(User user);
}
