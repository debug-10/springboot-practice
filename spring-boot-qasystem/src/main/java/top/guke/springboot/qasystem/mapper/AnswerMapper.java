package top.guke.springboot.qasystem.mapper;



import org.apache.ibatis.annotations.Mapper;
import top.guke.springboot.qasystem.entity.Answer;

import java.util.List;

@Mapper
public interface AnswerMapper {
    void insertAnswer(Answer answer);
    List<Answer> findByQuestionId(Integer questionId);
}
