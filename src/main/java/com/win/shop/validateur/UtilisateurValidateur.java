package com.win.shop.validateur;

import com.win.shop.dto.UtilisateurDto;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidateur {

    public static List<String> validate (UtilisateurDto utilisateurDto) {

        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null) {
            errors.add("aucune champ remplie !");
        }

        if (utilisateurDto.getNom().isEmpty()) {
            errors.add("nom vide !");
        }
        if (utilisateurDto.getPrenom().isEmpty()) {
            errors.add("prenom vide !");
        }
        if (utilisateurDto.getAddress()==null) {
            errors.add("address vide !");
        }

        return errors;
    }
}
