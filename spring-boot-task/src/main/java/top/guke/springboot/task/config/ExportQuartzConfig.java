package top.guke.springboot.task.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.guke.springboot.task.jobs.ExportJob;
import top.guke.springboot.task.jobs.SimpleQuartzTask;

//@Configuration
public class ExportQuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(ExportJob.class)
                .withIdentity("ExportTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {

        // 指定执行周期 , 每510秒
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");

        //返回任务触发器
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("exportTask")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
