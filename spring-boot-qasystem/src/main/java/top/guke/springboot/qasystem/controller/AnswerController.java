package top.guke.springboot.qasystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.guke.springboot.qasystem.entity.Answer;
import top.guke.springboot.qasystem.mapper.AnswerMapper;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    private AnswerMapper answerMapper;

    @PostMapping
    public void postAnswer(@RequestBody Answer answer) {
        // 确保设置问题和用户
        answerMapper.insertAnswer(answer);
    }

    @GetMapping("/question/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Integer questionId) {
        return answerMapper.findByQuestionId(questionId);
    }
}
