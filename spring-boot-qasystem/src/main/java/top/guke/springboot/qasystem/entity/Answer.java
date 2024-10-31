package top.guke.springboot.qasystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer {
    private Integer answerId;
    private String answerContent;
    private Question question; // 可以使用 Question 类型的引用
    private User user; // 可以使用 User 类型的引用

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt; // 设置为自定义格式
}
