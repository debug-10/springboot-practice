package top.guke.springboot.qasystem.entity;

import java.util.Date;
import java.util.List;

public class Question {
    private Integer questionId;
    private String questionContent;
    private Integer userId;
    private Date questionCreated;

    private List<Answer> answers;
    private List<User> users;
}
