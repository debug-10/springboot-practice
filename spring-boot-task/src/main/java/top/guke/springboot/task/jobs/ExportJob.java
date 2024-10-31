package top.guke.springboot.task.jobs;

import com.alibaba.excel.EasyExcel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import top.guke.springboot.task.entity.Student;
import top.guke.springboot.task.mapper.StudentMapper;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
public class ExportJob extends QuartzJobBean {
    protected final StudentMapper studentMapper;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<Student> students = studentMapper.selectList(null);
        String  fileName= "D:/HuaweiMoveData/Users/keke666/Desktop/" + UUID.randomUUID()+".xlsx";
        EasyExcel.write(fileName,Student.class)
                .sheet("学生数据")
                .doWrite(() -> students);
    }
}
