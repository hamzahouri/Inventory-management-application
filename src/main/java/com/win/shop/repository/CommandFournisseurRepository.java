package com.win.shop.repository;

import com.win.shop.model.CommandClient;
import com.win.shop.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandFournisseurRepository extends JpaRepository<CommandeFournisseur,Long> {
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
