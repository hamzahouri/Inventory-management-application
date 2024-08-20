package com.win.shop.service.Impl;

import com.win.shop.Exception.EntityNotFoundException;
import com.win.shop.Exception.ErrorsCode;
import com.win.shop.Exception.InvalidEntityException;
import com.win.shop.dto.CommandeFournisseurDto;
import com.win.shop.dto.LignVenteDto;
import com.win.shop.dto.VentesDto;
import com.win.shop.model.Article;
import com.win.shop.model.LignVente;
import com.win.shop.model.Ventes;
import com.win.shop.repository.ArticleRepository;
import com.win.shop.repository.LignVentesRepository;
import com.win.shop.repository.VentesRepository;
import com.win.shop.service.VenteService;
import com.win.shop.validateur.VenteValidateur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenteServiceImpl implements VenteService {

    private final VentesRepository ventesRepository;
    private final ArticleRepository articleRepository;
    private final LignVentesRepository lignVentesRepository;


    @Override
    public VentesDto save(VentesDto ventesDto) {
        List<String> errors = VenteValidateur.validate(ventesDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Ventes non valid", ErrorsCode.VENTE_NOT_VALID,errors);
        }

        List<String> error = new ArrayList<>();
        ventesDto.getVenteDtoList().forEach(lignVenteDto -> {
            Optional<Article> article = articleRepository.findById(Long.valueOf(lignVenteDto.getArticle().getId()));
            if (article.isEmpty()) {
                error.add("Aucune article avec L'ID"+Long.valueOf(lignVenteDto.getArticle().getId())+"existe");
            }
        });

        if (!error.isEmpty()) {
            throw new InvalidEntityException("un ou plusieurs Article n'ont pas trouver",ErrorsCode.VENTE_NOT_VALID,error);
        }

       Ventes savedVentes = ventesRepository.save(ventesDto.toEntity(ventesDto));
        ventesDto.getVenteDtoList().forEach(lgnVentes -> {
            lgnVentes.setVentes(savedVentes);

        });

        return VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Long id) {
        if(id ==null) {
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow( ()-> new EntityNotFoundException(
                        "Aucune ventes exuste avec L'id"+id,ErrorsCode.VENTE_NOT_FOUND
                ));
    }

    @Override
    public VentesDto findByCodeArticle(String code) {
        return null;
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream().map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            return;
        }
   ventesRepository.deleteById(id);
    }
}
