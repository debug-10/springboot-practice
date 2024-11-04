package top.guke.springboot.filter_interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FilterinterceptorApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterinterceptorApplication.class, args);
    }
}