package com.tech4music.musicas.services;

import java.util.List;
import java.util.Optional;


import com.tech4music.musicas.shared.MusicaDTO;
import org.springframework.stereotype.Service;

@Service
public interface MusicaService {

    List<MusicaDTO> obterTodos();

    Optional<MusicaDTO> obterPorId(String idMusica);

    MusicaDTO adicionar(MusicaDTO musicaDto);
    
    MusicaDTO atualizar(String idMusica, MusicaDTO musicadDto);

    void deletar(String idMusica);
    
    
    
}
