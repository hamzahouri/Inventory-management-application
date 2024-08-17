package com.win.shop.dto;

import com.win.shop.model.Address;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDto
{
    private Integer id;
    private String address1;
    private String address2;
    private String ville;
    private String codePostal;
    private String pays;

    public AddressDto fromEntity (Address address) {
        if (address == null) {
            return null;
        }
        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .codePostal(address.getCodePostal())
                .ville(address.getVille())
                .pays(address.getPays())
                .build();
    }

    public Address toEntity (AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        Address address = new Address();
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setCodePostal(addressDto.getCodePostal());
        address.setVille(addressDto.getVille());
        address.setPays(addressDto.getPays());
        return address;
    }
}
