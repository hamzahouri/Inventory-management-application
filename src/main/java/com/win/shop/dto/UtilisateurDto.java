package com.win.shop.dto;

import com.win.shop.model.Address;
import com.win.shop.model.Entreprise;
import com.win.shop.model.Role;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UtilisateurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private Address address;
    private String photo;
    private Entreprise entreprise;
    private List<Role> roles;
}
