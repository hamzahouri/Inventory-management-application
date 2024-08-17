package com.win.shop.dto;

import com.win.shop.model.Article;
import com.win.shop.model.Ventes;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class LignVenteDto {
    private Integer id;
    private Article article;
    private Ventes ventes;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
