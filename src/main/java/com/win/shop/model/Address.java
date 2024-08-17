package com.win.shop.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Address {
    private String address1;
    private String address2;
    private String ville;
    private String codePostal;
    private String pays;
}
