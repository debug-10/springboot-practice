package top.guke.springboot.qasystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.guke.springboot.qasystem.entity.User;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findByUsername(String username);
}