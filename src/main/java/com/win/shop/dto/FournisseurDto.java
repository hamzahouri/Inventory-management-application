package com.win.shop.dto;

import com.win.shop.model.Address;
import com.win.shop.model.CommandeFournisseur;
import com.win.shop.model.Entreprise;
import com.win.shop.model.Fournisseur;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FournisseurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String mail;
    private String photo;
    private String numTele;
    private Address address;
    private List<CommandeFournisseur> commandesFournisseur;

    public FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .address(fournisseur.getAddress())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .mail(fournisseur.getMail())
                .numTele(fournisseur.getNumTele())
                .commandesFournisseur(fournisseur.getCommandesFournisseur())
                .build();
    }


    public Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        }

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setAddress(fournisseurDto.getAddress());
        fournisseur.setNumTele(fournisseurDto.getNumTele());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setCommandesFournisseur(fournisseurDto.getCommandesFournisseur());
        return fournisseur;
    }
}
