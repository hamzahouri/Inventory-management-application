package com.win.shop.dto.auth;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthenticationResponse {

    private String accessToken;
}
