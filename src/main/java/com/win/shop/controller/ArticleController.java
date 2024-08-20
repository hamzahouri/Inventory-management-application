package com.win.shop.controller;

import com.win.shop.controller.api.ArticleApi;
import com.win.shop.dto.ArticleDto;
import com.win.shop.service.ArticleService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Long id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        return articleService.findByCodeArticle(code);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Long id) {
     articleService.delete(id);
    }
}
