package com.example.springbootreactauth.service;

import com.example.springbootreactauth.model.User;
import com.example.springbootreactauth.repository.UserRepository;
import com.example.springbootreactauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user){
        user.setFirstName(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}