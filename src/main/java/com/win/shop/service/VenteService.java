package com.win.shop.service;

import com.win.shop.dto.ArticleDto;
import com.win.shop.dto.VentesDto;

import java.util.List;

public interface VenteService {
    VentesDto save (VentesDto ventesDto);
    VentesDto findById (Long id);
    VentesDto findByCodeArticle (String code);
    List<VentesDto> findAll ();
    void delete (Long id);

}
