package com.win.shop.repository;

import com.win.shop.model.LignCommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignCommandFournisseurRepository extends JpaRepository<LignCommandFournisseur,Long> {

}
