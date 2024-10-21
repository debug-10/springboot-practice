package top.guke.springboot.redis.config;



public class RedisKeys {
    //验证码的 key
    public static String getSmsKey(String phone) {
        return "sms:captcha" + phone;
    }


    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }

    public static String getUserIdKey(Long id) {
        return "sys:userId:" + id;
    }


}
