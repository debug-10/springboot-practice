package top.guke.springboot.qasystem.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import top.guke.springboot.qasystem.entity.Question;

import static org.junit.jupiter.api.Assertions.*;

class QuestionControllerTest {

    @Resource
    private QuestionMapper questionMapper;

    @Test
    void getQuestionDetail() {
        Question question = questionMapper.getQuestionDetail(1);

    }
}