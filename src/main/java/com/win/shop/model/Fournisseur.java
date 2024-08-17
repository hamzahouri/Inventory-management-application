package com.win.shop.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Fournisseur extends AbstractEntity {

    private String nom;
    private String prenom;
    private String mail;
    private String photo;
    private String numTele;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandesFournisseur;
}
