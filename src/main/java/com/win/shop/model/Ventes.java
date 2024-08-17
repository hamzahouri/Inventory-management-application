package com.win.shop.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Ventes extends AbstractEntity{

    private String code;
    private Instant dateVente;
    private String commentaire;
}
