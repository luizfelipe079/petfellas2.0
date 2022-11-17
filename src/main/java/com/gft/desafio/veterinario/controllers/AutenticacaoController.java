package com.gft.desafio.veterinario.controllers;

import com.gft.desafio.veterinario.controllers.form.AutenticacaoForm;
import com.gft.desafio.veterinario.dto.auth.TokenDTO;
import com.gft.desafio.veterinario.service.auth.AutenticacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/login")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoForm authForm) {

        try {
            return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
