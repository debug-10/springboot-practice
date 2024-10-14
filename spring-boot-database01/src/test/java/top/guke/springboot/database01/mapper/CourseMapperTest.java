package top.guke.springboot.database01.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.guke.springboot.database01.entity.Course;
import top.guke.springboot.database01.entity.Student;

import java.util.List;

@SpringBootTest
@Slf4j
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    void selectAll() {
        List<Course> courses = courseMapper.selectAll();
        courses.forEach(course -> {
            log.info("{}",course.getCourseName());
            List<Student> students = course.getStudents();
            students.forEach(student -> log.info("{},{}",student.getStudentName(), student.getHometown()));
        });
    }
}