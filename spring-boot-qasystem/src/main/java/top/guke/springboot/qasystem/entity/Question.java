package top.guke.springboot.qasystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {
    private Integer questionId; // 可选，若在数据库中定义为 AUTO_INCREMENT，则可以不在请求体中提供
    private String questionContent; // 必填
    private User user; // 可选，假设用户信息在其他地方管理

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createTime; // 必填
}

