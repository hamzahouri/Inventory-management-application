package com.win.shop.dto;

import com.win.shop.model.Address;
import com.win.shop.model.CommandeFournisseur;
import com.win.shop.model.Entreprise;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {
    private Integer id;
    private String nom;
    private Address address;
    private String codeFiscale;
    private String photo;
    private String email;
    private String numTele;
    private String sitWeb;
    private String description;

    public EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .address(entreprise.getAddress())
                .codeFiscale(entreprise.getCodeFiscale())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTele(entreprise.getNumTele())
                .sitWeb(entreprise.getSitWeb())
                .description(entreprise.getDescription())
                .build();
    }


    public Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setAddress(entrepriseDto.getAddress());
        entreprise.setCodeFiscale(entrepriseDto.getCodeFiscale());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setNumTele(entrepriseDto.getNumTele());
        entreprise.setSitWeb(entrepriseDto.getSitWeb());
        entreprise.setPhoto(entreprise.getPhoto());
        return entreprise;
    }
}
