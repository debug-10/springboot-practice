package top.guke.springboot.quick.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.guke.springboot.quick.service.UserService;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/adults")
    public List<String> getAdultsUserName(){
        return userService.getAdultUserName();
    }
}
