package com.win.shop.controller.api;

import com.win.shop.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.win.shop.utils.Constants.APP_ROOT;

public interface ArticleApi {

    @PostMapping(value = APP_ROOT+"/articles/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save (@RequestBody ArticleDto articleDto);

    @GetMapping(value = APP_ROOT+"/articles/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById (@PathVariable("idArticle") Long id);

    @GetMapping(value = APP_ROOT+"/articles/{codeArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle (@PathVariable("codeArticle")String code);

    @GetMapping(value = APP_ROOT+"/articles/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll ();

    @DeleteMapping(value = APP_ROOT+"/articles/delete/{idArticle}")
    void delete (@PathVariable("idArticle") Long id);
}
