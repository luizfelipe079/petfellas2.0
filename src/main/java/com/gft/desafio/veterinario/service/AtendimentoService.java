package com.gft.desafio.veterinario.service;

import com.gft.desafio.veterinario.dto.atendimento.AtendimentoRequest;
import com.gft.desafio.veterinario.entities.Atendimento;
import com.gft.desafio.veterinario.entities.Cachorro;
import com.gft.desafio.veterinario.entities.Cliente;
import com.gft.desafio.veterinario.entities.Veterinario;
import com.gft.desafio.veterinario.exceptions.EntityNotFoundException;
import com.gft.desafio.veterinario.repositories.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final ClienteService clienteService;
    private final VeterinarioService veterinarioService;
    private final CachorroService cachorroService;

    public AtendimentoService(AtendimentoRepository atendimentoRepository, ClienteService clienteService, VeterinarioService veterinarioService, CachorroService cachorroService) {
        this.atendimentoRepository = atendimentoRepository;
        this.clienteService = clienteService;
        this.veterinarioService = veterinarioService;
        this.cachorroService = cachorroService;
    }

    public List<Atendimento> buscarAtendimentos(){
        return atendimentoRepository.findAll();
    }

    public Atendimento buscarPorId(Long id){
        return atendimentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Atendimento não encontrado"));
    }

    public Atendimento salvarAtendimento(Atendimento atendimento){
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento editarAtendimento(Atendimento atendimento, Long id){
        Atendimento atendimentoOriginal = this.buscarPorId(id);
        atendimento.setId(atendimentoOriginal.getId());

        return atendimentoRepository.save(atendimento);
    }

    public void excluirAtendimento(Long id){
        Atendimento atendimento = this.buscarPorId(id);

        atendimentoRepository.delete(atendimento);
    }

    public Atendimento addEntidades(AtendimentoRequest atendimentoRequest){
        Cliente cliente = clienteService.obterPorId(atendimentoRequest.getClienteId());
        Veterinario veterinario = veterinarioService.obterPorId(atendimentoRequest.getVeterinarioId());
        Cachorro cachorro = cachorroService.obterPorId(atendimentoRequest.getCachorroId());

        return new Atendimento(
                null,
                atendimentoRequest.getData(),
                atendimentoRequest.getHora(),
                atendimentoRequest.getIdade_dia(),
                atendimentoRequest.getPeso_dia(),
                atendimentoRequest.getAltura_dia(),
                atendimentoRequest.getLargura_dia(),
                atendimentoRequest.getDiagnostico(),
                atendimentoRequest.getComentarios(),
                cliente,
                veterinario,
                cachorro
                );

    }

    public List<Atendimento> buscarAtendimentosCliente(String email){
        return atendimentoRepository.findByClienteByemail(email);
    }
}
