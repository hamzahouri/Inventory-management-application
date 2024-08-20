package com.win.shop.validateur;

import com.win.shop.dto.ArticleDto;
import com.win.shop.dto.CommandClientDto;

import java.util.ArrayList;
import java.util.List;

public class CommandClientValidateur {

    public static List<String> validate(CommandClientDto commandClientDto) {
        List<String> errors = new ArrayList<>();

        if (commandClientDto.getCode() ==null
                && commandClientDto.getClient() ==null
                && commandClientDto.getDateCommande()==null) {
            errors.add("command vide. cod ou client ou date est vide");
        }


        return errors;
    }
}
