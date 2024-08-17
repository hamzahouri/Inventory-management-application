package com.win.shop.validateur;

import com.win.shop.dto.ArticleDto;
import com.win.shop.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidateur {

    public static List<String> validate (ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();
        if ( articleDto.getCodeArticle().isEmpty()) {
            errors.add("Veuillez renseigner le code de l'article");
        }

        if ( articleDto.getPrixUnitaireHt()==null) {
            errors.add("Veuillez renseigner le prix de l'article");
        }
        return errors;
    }
}
