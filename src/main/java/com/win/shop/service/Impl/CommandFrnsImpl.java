package com.win.shop.service.Impl;

import com.win.shop.Exception.EntityNotFoundException;
import com.win.shop.Exception.ErrorsCode;
import com.win.shop.Exception.InvalidEntityException;
import com.win.shop.dto.CommandClientDto;
import com.win.shop.dto.CommandeFournisseurDto;
import com.win.shop.model.*;
import com.win.shop.repository.ArticleRepository;
import com.win.shop.repository.CommandFournisseurRepository;
import com.win.shop.repository.FournisseurRepository;
import com.win.shop.repository.LignCommandFournisseurRepository;
import com.win.shop.service.CommandFournisseurService;
import com.win.shop.validateur.CommandClientValidateur;
import com.win.shop.validateur.CommandFournisseurValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommandFrnsImpl implements CommandFournisseurService {

    private final LignCommandFournisseurRepository lignCommandFournisseurRepository;
    private final CommandFournisseurRepository commandFournisseurRepository;
    private final ArticleRepository articleRepository;
    private final FournisseurRepository fournisseurRepository;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto fournisseurDto) {
        List<String> errors = CommandFournisseurValidateur.validate(fournisseurDto);
        if(!errors.isEmpty()) {
            throw new InvalidEntityException("Command n'est pas valid", ErrorsCode.COMMAND_Fournisseur_NOT_VALID,errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(Long.valueOf(fournisseurDto.getFournisseur().getId()));
        if (!fournisseur.isPresent()) {
            throw new EntityNotFoundException("Aucune Fournisseur avec ce id est trouver",ErrorsCode.Founisseur_NOT_FOUND);
        }

        List<String> articlerrors = new ArrayList<>();
        if(fournisseurDto.getLignsCommandFournisseur() !=null) {
            fournisseurDto.getLignsCommandFournisseur().forEach(lgnCmdt -> {
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

        CommandeFournisseur savedCommandFrns = commandFournisseurRepository.save(fournisseurDto.toEntity(fournisseurDto));
        fournisseurDto.getLignsCommandFournisseur().forEach(cmdclt -> {
            cmdclt.setCommandeFournisseur(savedCommandFrns);
            lignCommandFournisseurRepository.save(cmdclt);
        });

        return fournisseurDto.fromEntity(savedCommandFrns);
    }

    @Override
    public CommandeFournisseurDto findById(Long id) {
        if(id ==null) {
            return null;
        }
        return commandFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow( ()-> new EntityNotFoundException(
                        "Aucune commande exuste avec L'id"+id,ErrorsCode.COMMAND_Fournisseur_NOT_FOUND
                ));
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(code.isEmpty()) {
            return null;
        }
        return commandFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow( ()-> new EntityNotFoundException(
                        "Aucune commande exIste avec ce code"+code,ErrorsCode.COMMAND_Fournisseur_NOT_FOUND
                ));

    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandFournisseurRepository.findAll()
                .stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            return;
        }
        commandFournisseurRepository.deleteById(id);

    }
}
