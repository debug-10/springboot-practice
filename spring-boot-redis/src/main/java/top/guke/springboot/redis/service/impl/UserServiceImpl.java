package top.guke.springboot.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.guke.springboot.redis.cache.TokenStoreCache;
import top.guke.springboot.redis.config.RedisCache;
import top.guke.springboot.redis.config.RedisKeys;
import top.guke.springboot.redis.entity.User;
import top.guke.springboot.redis.enums.AccountStatusEnum;
import top.guke.springboot.redis.enums.ErrorCode;
import top.guke.springboot.redis.exception.ServerException;
import top.guke.springboot.redis.mapper.UserMapper;
import top.guke.springboot.redis.service.UserService;
import top.guke.springboot.redis.utils.JwtUtil;
import top.guke.springboot.redis.vo.UserInfoVO;
import top.guke.springboot.redis.vo.UserLoginVO;


/**
 * @author PC
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final RedisCache redisCache;
    private final TokenStoreCache tokenStoreCache;

    @Override
    public UserLoginVO loginByPhone(String phone, String code) {
        // 获取验证码cacheKey
        String smsCacheKey = RedisKeys.getSmsKey(phone);
        // 从redis中获取验证码
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
        // 校验验证码合法性
        if (ObjectUtils.isEmpty(redisCode) || !redisCode.toString().equals(code)) {
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        redisCache.delete(smsCacheKey);
        // 根据手机号获取用户
        User user = baseMapper.getByPhone(phone);
        // 判断用户是否注册过，如果user为空代表未注册，进行注册。否则开启登录流程
        if (ObjectUtils.isEmpty(user)) {
            log.info("用户不存在，创建用户，phone: {}", phone);
            user = new User();
            user.setNickname(phone);
            user.setPhone(phone);
            user.setAvatar("https://nit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/me.png");
            user.setGender(0);
            user.setEnabled(AccountStatusEnum.ENABLED.getValue());
            user.setBonus(100);
            user.setDeleteFlag(0);
            user.setRemark("这个人很懒，什么都没有写");
            baseMapper.insert(user);
        }
        // 用户被禁用
        if (!user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue())) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }
        // 构造token
        String accessToken = JwtUtil.createToken(user.getPkId());
        // 构造登陆返回vo
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setPkId(user.getPkId());
        userLoginVO.setPhone(user.getPhone());
        userLoginVO.setAccessToken(accessToken);
        tokenStoreCache.saveUser(accessToken, userLoginVO);
        return userLoginVO;
    }


    @Override
    public boolean checkUserEnabled(Long userId) {
        User user = baseMapper.selectById(userId);
        if (ObjectUtils.isEmpty(user)) {
            return false;
        }
        return user.getEnabled().equals(AccountStatusEnum.ENABLED.getValue());
    }

    @Override
    public UserInfoVO userInfo(Long userId) {
        // 查询数据库
        User user = baseMapper.selectById(userId);
        if (user == null) {
            log.error("用户不存在，userId: {}", userId);
            throw new ServerException(ErrorCode.USER_NOT_EXIST);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);
        return userInfoVO;
    }


}