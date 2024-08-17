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
public class Client extends AbstractEntity{

    private String nom;
    private String prenom;
    private String mail;
    private String photo;
    private String numTele;
    @Embedded
    private Address addresse;
    @OneToMany(mappedBy = "client")
    private List<CommandClient> commandClients;
}
