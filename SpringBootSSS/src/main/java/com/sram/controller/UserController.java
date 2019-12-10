package com.sram.controller;

import com.sram.common.CodeMenu;
import com.sram.common.ResponseResult;
import com.sram.entity.User;
import com.sram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin// 跨域请求
public class UserController {

    @Autowired
    private UserService userService;

    //@RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @GetMapping("/findAll")
    public ResponseResult<User> findAll(){

        List<User> userList = userService.findAll();

        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);
        rr.setUser(new User());
        rr.setUserList(userList);
        return rr;
    }

    @GetMapping("/findById")
    public ResponseResult<User> findById(int id){

        User user = userService.findById(id);
        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);
        rr.setUser(user);
        rr.setUserList(new ArrayList<>());
        return rr;
    }

    @PostMapping("/updateUser")
    public ResponseResult<User> updateUser(@RequestBody User user){

        System.out.println(user);
        userService.updateUser(user);
        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);
        rr.setUser(new User());
        rr.setUserList(new ArrayList<>());
        return rr;
    }

}

