package top.guke.springboot.qasystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.guke.springboot.qasystem.entity.Question;
import top.guke.springboot.qasystem.mapper.QuestionMapper;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionMapper.findAllQuestions();
    }

    @PostMapping
    public ResponseEntity<String> postQuestion(@RequestBody Question question) {
        try {
            // 检查必填字段
            if (question.getQuestionContent() == null || question.getCreateTime() == null) {
                return ResponseEntity.badRequest().body("问题内容和创建时间不能为空");
            }

            // 保存问题
            questionMapper.insertQuestion(question);
            return ResponseEntity.status(HttpStatus.CREATED).body("问题已创建");
        } catch (Exception e) {
            // 记录异常
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("创建问题失败: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
        Question question = questionMapper.findById(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }
}
