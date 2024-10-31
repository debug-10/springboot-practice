package top.guke.springboot.qasystem.mapper;

import top.guke.springboot.qasystem.entity.Question;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface QuestionMapper {
    void insertQuestion(Question question);
    List<Question> findAllQuestions();
    Question findById(Integer id);
}