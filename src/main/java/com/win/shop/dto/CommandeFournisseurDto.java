package com.win.shop.dto;

import com.win.shop.model.CommandClient;
import com.win.shop.model.CommandeFournisseur;
import com.win.shop.model.Fournisseur;
import com.win.shop.model.LignCommandFournisseur;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeFournisseurDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private Fournisseur fournisseur;
    private List<LignCommandFournisseur> lignsCommandFournisseur;

    public CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null) {
            return null;
        }
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(commandeFournisseur.getFournisseur())
                .lignsCommandFournisseur(commandeFournisseur.getLignsCommandFournisseur())
                .build();
    }


    public CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null) {
            return null;
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        commandeFournisseur.setFournisseur(commandeFournisseurDto.getFournisseur());
        commandeFournisseur.setLignsCommandFournisseur(commandeFournisseurDto.getLignsCommandFournisseur());
        return commandeFournisseur;
    }
}
