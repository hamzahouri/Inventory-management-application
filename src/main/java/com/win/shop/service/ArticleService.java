package com.win.shop.service;

import com.win.shop.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save (ArticleDto articleDto);
    ArticleDto findById (Long id);
    ArticleDto findByCodeArticle (String code);
    List<ArticleDto> findAll ();
    void delete (Long id);
}
