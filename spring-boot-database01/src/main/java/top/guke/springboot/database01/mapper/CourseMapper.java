package top.guke.springboot.database01.mapper;

import top.guke.springboot.database01.entity.Course;

import java.util.List;

public interface CourseMapper {
    List<Course> selectAll();
}
