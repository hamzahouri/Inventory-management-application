package com.win.shop.validateur;

import com.win.shop.dto.CommandClientDto;
import com.win.shop.dto.CommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class CommandFournisseurValidateur {
    public static List<String> validate(CommandeFournisseurDto fournisseurDto) {
        List<String> errors = new ArrayList<>();

        if (fournisseurDto.getCode() ==null
                && fournisseurDto.getFournisseur() ==null
                && fournisseurDto.getDateCommande()==null) {
            errors.add("command vide. cod ou client ou date est vide");
        }


        return errors;
    }

    }

