package com.win.shop.repository;

import com.win.shop.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    Optional<Article> findArticleByCodeArticle(String code);
}
