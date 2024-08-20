package com.win.shop.service;

import com.win.shop.dto.CommandClientDto;

import java.util.List;

public interface CommandClientService {

    CommandClientDto save (CommandClientDto commandClientDto);
    CommandClientDto findById (Long id);
    CommandClientDto findByCode (String code);
    List<CommandClientDto> findAll ();
    void delete (Long id);
}
