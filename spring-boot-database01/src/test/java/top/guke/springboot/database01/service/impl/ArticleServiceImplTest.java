package top.guke.springboot.database01.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.guke.springboot.database01.entity.Article;
import top.guke.springboot.database01.service.ArticleService;


import java.util.List;

@SpringBootTest
@Slf4j
class ArticleServiceTest {
    @Resource
    private ArticleService articleService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .title("SpringBoot")
                .author("张三")
                .content("SpringBoot 从入门到精通")
                .build();
        Article saveArticle = articleService.saveArticle(article);
        log.info(String.valueOf(saveArticle));
    }


    @Test
    void updateArticle() {
        Article article = articleService.getArticle(4L);
        article.setTitle("SpringBoot222");
        articleService.updateArticle(article);
    }

    @Test
    void getArticle() {
        Article article = articleService.getArticle(1L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
        List<Article> articles = articleService.getAll();
        articles.forEach(article -> log.info(String.valueOf(article)));
    }

    @Test
    void deleteArticle() {
        articleService.deleteArticle(4L);
    }
}