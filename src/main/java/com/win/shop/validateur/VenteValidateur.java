package com.win.shop.validateur;

import com.win.shop.dto.CategoryDto;
import com.win.shop.dto.VentesDto;

import java.util.ArrayList;
import java.util.List;

public class VenteValidateur {

    public static List<String> validate (VentesDto ventesDto) {
        List<String> errors = new ArrayList<>();
        if (ventesDto == null || ventesDto.getCode().isEmpty()) {
            errors.add("Veuillez renseigner le code de la category");
        }
        return errors;
    }
}
