package top.guke.springboot.configure.service;

import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TestBeanServiceTest {

    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    void test() {
        boolean flag = ioc.containsBean("TestBeanService");
//        assertTrue(flag);
        TestBeanService testBeanService = (TestBeanService) ioc.getBean("testBeanService");
        log.info(String.valueOf(testBeanService));
        assertEquals("SpringBoot" , testBeanService.getName());

    }
}