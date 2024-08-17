package com.win.shop.dto;

import com.win.shop.model.Address;
import com.win.shop.model.Category;
import com.win.shop.model.Client;
import com.win.shop.model.CommandClient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String mail;
    private String photo;
    private String numTele;
    private Address addresse;
    private List<CommandClient> commandClients;

    public ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .mail(client.getMail())
                .photo(client.getPhoto())
                .numTele(client.getNumTele())
                .addresse(client.getAddresse())
                .commandClients(client.getCommandClients())
                .build();
    }


    public Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }

        Client client = new Client();
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setMail(clientDto.getMail());
        client.setNumTele(clientDto.getNumTele());
        client.setPhoto(clientDto.getPhoto());
        client.setAddresse(clientDto.getAddresse());
        client.setId(clientDto.getId());
        client.setCommandClients(clientDto.getCommandClients());
        return client;
    }
}
