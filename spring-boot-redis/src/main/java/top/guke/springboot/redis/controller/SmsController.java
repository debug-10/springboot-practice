package top.guke.springboot.redis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.guke.springboot.redis.result.Result;
import top.guke.springboot.redis.service.SmsServer;

@RestController
@RequestMapping("/sms")
@AllArgsConstructor
public class SmsController {
    private final SmsServer smsServer;

    @PostMapping("/send")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        smsServer.sendSms(phone);
        return Result.ok();
    }
}
