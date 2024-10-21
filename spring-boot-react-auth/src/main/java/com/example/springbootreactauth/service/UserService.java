package com.example.springbootreactauth;


public interface UserService {
    User findByEmail(String email);
    User saveUser(User user);
}
