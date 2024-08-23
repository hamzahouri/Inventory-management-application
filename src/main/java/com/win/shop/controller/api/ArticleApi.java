package com.win.shop.controller.api;

import com.win.shop.dto.ArticleDto;
;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.win.shop.utils.Constants.APP_ROOT;
//@Api(APP_ROOT+"/Article")

public interface ArticleApi {

    @PostMapping(value = APP_ROOT+"/articles/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save an article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Article creee avec success")
    })
    ArticleDto save (@RequestBody ArticleDto articleDto);

    @GetMapping(value = APP_ROOT+"/articles/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary ="get an article by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "article trouver avec success"),
            @ApiResponse(responseCode = "404",description = "Aucune article trouver avec ce ID")
    })
    ArticleDto findById (@PathVariable("idArticle") Long id);

    @GetMapping(value = APP_ROOT+"/articles/{codeArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle (@PathVariable("codeArticle")String code);

    @GetMapping(value = APP_ROOT+"/articles/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll ();

    @DeleteMapping(value = APP_ROOT+"/articles/delete/{idArticle}")
    void delete (@PathVariable("idArticle") Long id);
}
