package com.gft.desafio.veterinario.dto.cachorro;

import com.gft.desafio.veterinario.entities.Cachorro;

public class CachorroMapper {

    public static Cachorro fromDTO(CachorroRequest cachorroRequest){
        return new Cachorro(
                null,
                cachorroRequest.getNome(),
                cachorroRequest.getRacaId(),
                cachorroRequest.getIdade(),
                cachorroRequest.getPeso(),
                cachorroRequest.getAltura(),
                cachorroRequest.getLargura(),
                null
        );
    }

    public static CachorroResponse fromEntity(Cachorro cachorro){
        return new CachorroResponse(
                cachorro.getId(),
                cachorro.getNome(),
                cachorro.getRacaId(),
                cachorro.getIdade(),
                cachorro.getPeso(),
                cachorro.getAltura(),
                cachorro.getLargura(),
                cachorro.getCliente().getNome()
        );
    }
}
