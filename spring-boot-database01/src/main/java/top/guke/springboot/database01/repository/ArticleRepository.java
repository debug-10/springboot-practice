package top.guke.springboot.database01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.guke.springboot.database01.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
