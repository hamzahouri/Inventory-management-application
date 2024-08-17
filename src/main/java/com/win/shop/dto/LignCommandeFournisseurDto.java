package com.win.shop.dto;

import com.win.shop.model.Article;
import com.win.shop.model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LignCommandeFournisseurDto {

    private Integer id;
    private Article article;
    private CommandeFournisseur commandeFournisseur;
}
