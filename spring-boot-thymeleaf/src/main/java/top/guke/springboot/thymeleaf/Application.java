package top.guke.springboot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    @GetMapping
    public String hello(String name){
        String greeting = "Hello！！！ " + name + "!";
        return greeting;
    }

//
//    @PostMapping("/")
//    public String sum(@RequestParam int num1, @RequestParam int num2){
//       int num3 = num1 + num2;
//       return "结果 " + num3 + "!";
//    }


    @GetMapping("/sum")
    public Integer getSum(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }




}



