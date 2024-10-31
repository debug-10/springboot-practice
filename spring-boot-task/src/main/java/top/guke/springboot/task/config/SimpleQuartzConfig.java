package top.guke.springboot.task.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.guke.springboot.task.jobs.SimpleQuartzTask;

//@Configuration
public class SimpleQuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(SimpleQuartzTask.class)
                .withIdentity("simpleQuartzTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {

        // 指定执行周期 , 每5秒
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        //返回任务触发器
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("simpleQuartzTask")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
