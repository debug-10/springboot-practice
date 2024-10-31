package top.guke.springboot.qasystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.guke.springboot.qasystem.entity.User;
import top.guke.springboot.qasystem.mapper.UserMapper;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userMapper.insertUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userMapper.findByUsername(user.getUsername());
    }
}