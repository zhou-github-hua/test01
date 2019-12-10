package com.sram.test;

import com.sram.MyApp;
import com.sram.dao.UserDao;
import com.sram.entity.User;
import com.sram.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApp.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUser1(){
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testUser2(){
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void testUser3(){
        User user = userService.findById(34);
        user.setUsername("赵六");
        userService.updateUser(user);
    }

}
