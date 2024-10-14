package top.guke.springboot.mp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.guke.springboot.mp.enetity.Clazz;
import top.guke.springboot.mp.enetity.Teacher;
import top.guke.springboot.mp.mapper.ClazzMapper;

@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;

//    public Clazz getClazzById(Long clazzId) {
//        Clazz clazz = clazzMapper.selectById(clazzId);
//        if (clazz != null) {
//            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
//            clazz.setTeacher(teacher);
//        }
//        return clazz;
//    }

    public Clazz getClazzWithTeacher(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }
}