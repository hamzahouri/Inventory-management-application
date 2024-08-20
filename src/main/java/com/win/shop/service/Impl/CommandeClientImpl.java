package com.win.shop.service.Impl;

import com.win.shop.Exception.EntityNotFoundException;
import com.win.shop.Exception.ErrorsCode;
import com.win.shop.Exception.InvalidEntityException;
import com.win.shop.dto.CommandClientDto;
import com.win.shop.model.Article;
import com.win.shop.model.Client;
import com.win.shop.model.CommandClient;
import com.win.shop.repository.ArticleRepository;
import com.win.shop.repository.ClientRepository;
import com.win.shop.repository.CommandClientRepository;
import com.win.shop.repository.LignCommandClientRepository;
import com.win.shop.service.CommandClientService;
import com.win.shop.validateur.CommandClientValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandeClientImpl implements CommandClientService {

    private final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;
    private final CommandClientRepository commandClientRepository;
    private final LignCommandClientRepository lignCommandClientRepository;

    @Override
    public CommandClientDto save(CommandClientDto commandClientDto) {
        List<String> errors = CommandClientValidateur.validate(commandClientDto);
        if(!errors.isEmpty()) {
            throw new InvalidEntityException("Command n'est pas valid", ErrorsCode.COMMAND_CLIENT_NOT_VALID,errors);
        }

        Optional<Client> client = clientRepository.findById(Long.valueOf(commandClientDto.getClient().getId()));
        if (!client.isPresent()) {
            throw new EntityNotFoundException("Aucune client avec ce id est trouver",ErrorsCode.CLIENT_NOT_FOUND);
        }

        List<String> articlerrors = new ArrayList<>();
        if(commandClientDto.getLignCommandeClients() !=null) {
            commandClientDto.getLignCommandeClients().forEach(lgnCmdt -> {
                if(lgnCmdt.getArticle() !=null) {
                    Optional<Article> article = articleRepository.findById(Long.valueOf(lgnCmdt.getArticle().getId()));
                    if (article.isEmpty()) {
                        articlerrors.add("L' article n'existe pas");
                    }
                }
            });
        }

        if(!articlerrors.isEmpty()) {
             throw new InvalidEntityException("Aucune article existe",ErrorsCode.ARTICLE_NOT_FOUND,articlerrors);
        }

        CommandClient savedCommandClient = commandClientRepository.save(CommandClientDto.toEntity(commandClientDto));
        commandClientDto.getLignCommandeClients().forEach(cmdclt -> {
            cmdclt.setCommandClient(savedCommandClient);
            lignCommandClientRepository.save(cmdclt);
        });

        return CommandClientDto.fromEntity(savedCommandClient);
    }

    @Override
    public CommandClientDto findById(Long id) {

        if(id ==null) {
            return null;
        }
        return commandClientRepository.findById(id)
                .map(CommandClientDto::fromEntity)
                .orElseThrow( ()-> new EntityNotFoundException(
                        "Aucune commande exuste avec L'id"+id,ErrorsCode.COMMAND_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandClientDto findByCode(String code) {
        if(code.isEmpty()) {
            return null;
        }
        return commandClientRepository.findCommandClientByCode(code)
                .map(CommandClientDto::fromEntity)
                .orElseThrow( ()-> new EntityNotFoundException(
                        "Aucune commande exuste avec ce code"+code,ErrorsCode.COMMAND_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<CommandClientDto> findAll() {
        return commandClientRepository.findAll()
                .stream()
                .map(CommandClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            return;
        }
        commandClientRepository.deleteById(id);

    }
}
