package top.guke.springboot.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "guke.sms.ccp")
public class CloopenConfig {

    private String serverIp;
    private String port;
    private String accountSId;
    private String accountToken;
    private String appId;
    private String templateId;
}