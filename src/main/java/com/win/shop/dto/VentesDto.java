package com.win.shop.dto;

import com.win.shop.model.Article;
import com.win.shop.model.Ventes;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
public class VentesDto {

    private Integer id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private List<LignVenteDto> venteDtoList;

    public static VentesDto fromEntity (Ventes ventes) {
        if (ventes == null) {
            return null;
        }
        return VentesDto.builder().id(ventes.getId())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .build();
    }

    public static Ventes toEntity (VentesDto ventesDto) {
        if (ventesDto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setCode(ventesDto.getCode());
        ventes.setDateVente(ventes.getDateVente());
        ventes.setCommentaire(ventes.getCommentaire());
        return ventes;
    }

}
