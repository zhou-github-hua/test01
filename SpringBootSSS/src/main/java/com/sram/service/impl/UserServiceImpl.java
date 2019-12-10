package com.sram.service.impl;

import com.sram.dao.UserDao;
import com.sram.entity.User;
import com.sram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer userId) {
        Optional<User> optional = userDao.findById(userId);
        return optional.get();
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }
}
