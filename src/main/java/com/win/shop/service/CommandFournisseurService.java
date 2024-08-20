package com.win.shop.service;

import com.win.shop.dto.CommandClientDto;
import com.win.shop.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandFournisseurService {
    CommandeFournisseurDto save (CommandeFournisseurDto fournisseurDto);
    CommandeFournisseurDto findById (Long id);
    CommandeFournisseurDto findByCode (String code);
    List<CommandeFournisseurDto> findAll ();
    void delete (Long id);
}
