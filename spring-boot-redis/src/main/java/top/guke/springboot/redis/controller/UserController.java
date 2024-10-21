package top.guke.springboot.redis.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.guke.springboot.redis.cache.TokenStoreCache;
import top.guke.springboot.redis.enums.ErrorCode;
import top.guke.springboot.redis.exception.ServerException;
import top.guke.springboot.redis.result.Result;
import top.guke.springboot.redis.service.UserService;
import top.guke.springboot.redis.utils.JwtUtil;
import top.guke.springboot.redis.vo.UserInfoVO;
import top.guke.springboot.redis.vo.UserLoginVO;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenStoreCache tokenStoreCache;

    @PostMapping("/login")
    @Operation(summary = "手机短信登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        return Result.ok(userService.loginByPhone(phone, code));
    }


    @GetMapping("info")
    @Operation(summary = "查询用户信息")
    public Result<UserInfoVO> userInfo() {
        //获得 HttpServletRequest 请求对象
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        //调用工具方法，从request中获得 accessToken
        String accessToken = JwtUtil.getAccessToken(request);

        //accessToken 为空，抛出UNAUTHORIZED 的异常信息
        if (StringUtils.isBlank(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }

        //校验 accessToken 是否有效，无效也是抛出 UNAUTHORIZED 异常信息
        if(!JwtUtil.validate(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }

        //根据 accessToken ，从 Redis 中查询到用户信息
        UserLoginVO user = tokenStoreCache.getUser(accessToken);

        // 没查到，抛出LOGIN STATUS EXPIRE 异常信息
        if (ObjectUtils.isEmpty(user)) {
            throw new ServerException(ErrorCode.LOGIN_STATUS_EXPIRE);
        }

        //验证用户是否可用
        boolean enabledFlag = userService.checkUserEnabled (user.getPkId());

        //不可用，抛出 ACCOUNT DISABLED 异常信息
        if (!enabledFlag) {
            throw new ServerException(ErrorCode.ACCOUNT_DISABLED);
        }
        return Result.ok(userService.userInfo(user.getPkId()));
    }
}
