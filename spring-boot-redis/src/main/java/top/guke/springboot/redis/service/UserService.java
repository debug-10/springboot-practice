package top.guke.springboot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.guke.springboot.redis.entity.User;
import top.guke.springboot.redis.vo.UserInfoVO;
import top.guke.springboot.redis.vo.UserLoginVO;


/**
 * @author PC
 */
public interface UserService extends IService<User> {


    UserLoginVO loginByPhone(String phone, String code);

    boolean checkUserEnabled(Long userId);

    UserInfoVO userInfo(Long userId);
}
