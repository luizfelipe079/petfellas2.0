package com.gft.desafio.veterinario.dto.veterinario;

import com.gft.desafio.veterinario.dto.endereco.EnderecoMapper;
import com.gft.desafio.veterinario.entities.Veterinario;

public class VeterinarioMapper {

    public static Veterinario fromDTO(VeterinarioRequest veterinarioRequest){
        return new Veterinario(null, veterinarioRequest.getNome(), veterinarioRequest.getEmail(), veterinarioRequest.getTelefone(), EnderecoMapper.fromDTO(veterinarioRequest.getEndereco()), veterinarioRequest.getNum_registro());
    }

    public static VeterinarioResponse fromEntity(Veterinario veterinario){
        return new VeterinarioResponse(veterinario.getId(), veterinario.getNome(), veterinario.getEmail(), veterinario.getTelefone(), EnderecoMapper.fromEntity(veterinario.getEndereco()), veterinario.getNum_registro());
    }
}
