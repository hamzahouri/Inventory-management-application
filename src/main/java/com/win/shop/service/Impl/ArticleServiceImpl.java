package com.win.shop.service.Impl;

import com.win.shop.Exception.EntityNotFoundException;
import com.win.shop.Exception.ErrorsCode;
import com.win.shop.Exception.InvalidEntityException;
import com.win.shop.dto.ArticleDto;
import com.win.shop.model.Article;
import com.win.shop.repository.ArticleRepository;
import com.win.shop.service.ArticleService;
import com.win.shop.validateur.ArticleValidateur;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Override
    public ArticleDto save(ArticleDto Dto) {
        List<String> errors = ArticleValidateur.validate(Dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}",Dto);
            throw new InvalidEntityException("article non valid", ErrorsCode.ARTICLE_NOT_Valid,errors);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(Dto)));
    }

    @Override
    public ArticleDto findById(Long id) {

        if (id ==null) {
            return null;
        }
        Optional<Article> article = Optional.ofNullable(articleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("aucune article avec ce id", ErrorsCode.ARTICLE_NOT_FOUND)));
        Article returendArticle = article.get();
        return ArticleDto.fromEntity(returendArticle);
    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        if (code ==null) {
            return null;
        }
        Optional<Article> article = Optional.ofNullable(articleRepository.findArticleByCodeArticle(code).orElseThrow(() ->
                new EntityNotFoundException("aucune article avec ce code", ErrorsCode.ARTICLE_NOT_FOUND)));
        Article returendArticle = article.get();
        return  ArticleDto.fromEntity(returendArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id ==null) {
            return;
        }
        articleRepository.deleteById(id);

    }
}
