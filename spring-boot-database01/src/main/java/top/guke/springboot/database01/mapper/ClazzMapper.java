package top.guke.springboot.database01.mapper;

import top.guke.springboot.database01.entity.Clazz;

public interface ClazzMapper {
    //根据id查询班级信息（一对多查出班级所有学生信息）
    Clazz getClazzById(int clazzId);

    Clazz getClazz(int clazzId);


}
