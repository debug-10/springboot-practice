package top.guke.springboot.database01.mapper;

import top.guke.springboot.database01.entity.Teacher;

public interface TeacherMapper {

    Teacher findTeacherById (int teacherId);
}
