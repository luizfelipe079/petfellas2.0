package com.gft.desafio.veterinario.dto.auth;

public class TokenDTO {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenDTO(String token) {
        this.token = token;
    }

    public TokenDTO() {
    }
}
