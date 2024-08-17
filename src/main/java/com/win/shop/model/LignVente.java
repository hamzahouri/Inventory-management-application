package com.win.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LignVente extends AbstractEntity{

    @ManyToOne
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes ventes;

    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
