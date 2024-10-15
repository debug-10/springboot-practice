package top.guke.springboot.exception.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.guke.springboot.exception.service.ExceptionService;

@RestController
public  class ExceptionController {
    @Resource
    private ExceptionService exceptionService;

    @GetMapping("/articles/{id}")
    public  void getArticle(@PathVariable("id") Integer id) {
        if(id == 1) {
            exceptionService.unAuthorizedError();
        }else  {
            exceptionService.systemError();
        }
    }
}
