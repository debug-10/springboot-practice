package top.guke.springboot.task.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_student")
public class Student {

    @ExcelProperty("学生学号")
    private Integer studentId;

    @ExcelIgnore
    private Integer clazzId;

    @ExcelProperty("学生姓名")
    private String studentName;

    @ExcelProperty("学生家乡")
    private String hometown;

    @ExcelIgnore
    private Data birthday;

}
