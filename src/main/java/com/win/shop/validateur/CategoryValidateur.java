package com.win.shop.validateur;

import com.win.shop.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidateur {

    public static List<String> validate (CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();
        if (categoryDto == null || categoryDto.getCode().isEmpty()) {
            errors.add("Veuillez renseigner le code de la category");
        }
  return errors;
    }

}
