package top.guke.springboot.quick.service;


import org.springframework.stereotype.Service;
import top.guke.springboot.quick.entiy.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Locale.filter;


@Service
public class UserService {
    private final List<User> users = List.of(
            new User(1L, "张三", 22),
            new User(2L, "张三丰", 27),
            new User(3L, "张三峰", 37),
            new User(4L, "张三疯", 17),
            new User(5L, "张三风", 21)
    );

    public List<String> getAdultUserName() {
        return users.stream()
                .filter(user -> user.getAge() > 18)
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
