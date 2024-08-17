package com.win.shop.dto;

import com.win.shop.model.Utilisateur;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    private Integer id;
    private String roleName;
    private Utilisateur utilisateur;
}
