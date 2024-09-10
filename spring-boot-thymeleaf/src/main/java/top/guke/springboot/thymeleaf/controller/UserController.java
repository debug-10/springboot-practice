package top.guke.springboot.thymeleaf.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.guke.springboot.thymeleaf.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String name, @RequestParam String email, Model model) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setId(users.size() + 1L);
        users.add(user);
        return "redirect:/users";
    }


    {
        users.add(new User(1L,  "zhangsan@qq.com","张三"));
        users.add(new User(2L,  "lisi@qq.com","李四"));
    }
}