package top.guke.springboot.task.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
@Slf4j
public class ScheduledJobs {

//    @Scheduled(fixedRate = 3000)
//    public void fixedRateJob() throws InterruptedException {
//        log.info("fixedRateJob start:{}" , new Date());
//        Thread.sleep(5000);
//        log.info("fixedRateJob end: {}" , new Date());
//    }


//    @Scheduled(fixedDelay = 3000)
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("fixedDelayJob start:{}" , new Date());
//        Thread.sleep(10000);
//        log.info("fixedDelayJob end: {}" , new Date());
//    }


    //每隔10秒
//        @Scheduled(cron = "0/10 * * * * ?")
//    public void fixedDelayJob() throws InterruptedException {
//        log.info("----------------cron 执行：{}" , new Date());
//    }

}
