package com.win.shop.dto;

import com.win.shop.model.Article;
import com.win.shop.model.CommandClient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class LignCommandeClientDto {

    private Integer id;
    private Article article;
    private CommandClient commandClient;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
