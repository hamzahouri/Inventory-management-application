package com.win.shop.service.Impl;

import com.win.shop.Exception.InvalidEntityException;
import com.win.shop.dto.ArticleDto;
import com.win.shop.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    private ArticleService articleService;


    @Test
    public void ShouldSaveArticle() {
        ArticleDto articleDto = ArticleDto.builder().
                codeArticle("article test").designation("des Article")
                .prixUnitaireHt(BigDecimal.valueOf(1298.00)).tauxTva(BigDecimal.valueOf(2.0)).
                build();
        ArticleDto savedArticle = articleService.save(articleDto);

        assertNotNull(savedArticle);
        assertEquals(articleDto.getCodeArticle(), savedArticle.getCodeArticle());
    }


}