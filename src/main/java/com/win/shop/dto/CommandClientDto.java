package com.win.shop.dto;

import com.win.shop.model.Client;
import com.win.shop.model.CommandClient;
import com.win.shop.model.LignCommandeClient;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
@Setter
public class CommandClientDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private Client client;
    private List<LignCommandeClient> lignCommandeClients;

    public static CommandClientDto fromEntity(CommandClient commandClient) {
        if (commandClient == null) {
            return null;
        }
        return CommandClientDto.builder()
                .id(commandClient.getId())
                .code(commandClient.getCode())
                .dateCommande(commandClient.getDateCommande())
                .client(commandClient.getClient())
                .lignCommandeClients(commandClient.getLignCommandeClients())
                .build();
    }


    public static CommandClient toEntity(CommandClientDto commandClientDto) {
        if (commandClientDto == null) {
            return null;
        }

        CommandClient commandClient = new CommandClient();
         commandClient.setId(commandClientDto.getId());
         commandClient.setCode(commandClientDto.getCode());
         commandClient.setDateCommande(commandClientDto.getDateCommande());
         commandClient.setLignCommandeClients(commandClientDto.getLignCommandeClients());
        return commandClient;
    }
}
