package com.win.shop.dto;

import com.win.shop.model.Article;
import com.win.shop.model.TypeMouvementStock;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MouvementStockDto {

    private Integer id;
    private Article article;
    private BigDecimal quantite;
    private Instant dateMvt;
    private TypeMouvementStock mouvementStock;
}
