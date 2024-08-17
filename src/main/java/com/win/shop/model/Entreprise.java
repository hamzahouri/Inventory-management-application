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
public class Entreprise extends AbstractEntity{

    private String nom;
    @Embedded
    private Address address;
    private String codeFiscale;
    private String photo;
    private String email;
    private String numTele;
    private String sitWeb;
    private String description;




//    @OneToMany(mappedBy = "entreprise")
//    private List<Article> articles;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

}
