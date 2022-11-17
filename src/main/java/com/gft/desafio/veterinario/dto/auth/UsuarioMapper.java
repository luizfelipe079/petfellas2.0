package com.gft.desafio.veterinario.dto.auth;

import com.gft.desafio.veterinario.entities.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO fromEntity(Usuario usuario){

        return new UsuarioDTO(usuario.getId(), usuario.getEmail(), usuario.getPerfil().getNome());
    }
}
