package com.win.shop.dto.auth;

import com.win.shop.Exception.EntityNotFoundException;
import com.win.shop.Exception.ErrorsCode;
import com.win.shop.model.Utilisateur;
import com.win.shop.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository repository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Utilisateur utilisateur = repository.findUtilisateurByEmail(email)
              .orElseThrow( ()-> new EntityNotFoundException("Utilisateur Not Found", ErrorsCode.Utilisateur_NOT_FOUND));

      List<SimpleGrantedAuthority> authorities = new ArrayList<>();
      utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

        return new User(utilisateur.getEmail(),utilisateur.getMotDePass(), authorities);

    }
}
