package com.sram.service;

import com.sram.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer userId);

    void updateUser(User user);
}
