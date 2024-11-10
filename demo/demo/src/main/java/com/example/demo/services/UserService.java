package com.example.demo.services;

import com.example.demo.controllers.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
}
