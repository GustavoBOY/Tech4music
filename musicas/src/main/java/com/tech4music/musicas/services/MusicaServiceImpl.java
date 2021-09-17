package com.tech4music.musicas.services;

//#region import Java util
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//#endregion

//#region import Tech4musci
import com.tech4music.musicas.model.Musica;
import com.tech4music.musicas.repository.MusicaRepository;
import com.tech4music.musicas.shared.MusicaDTO;
//#endregion

//#region import Org
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//#endregion

@Service
public class MusicaServiceImpl implements MusicaService {
    
    @Autowired
    MusicaRepository repositorioMusica;

    @Override
    public List<MusicaDTO> obterTodos() {
        
        List<Musica> musicas = repositorioMusica.findAll();

        ModelMapper mapper = new ModelMapper();
        return musicas.stream()
        .map(musica -> mapper.map(musica, MusicaDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<MusicaDTO> obterPorId(String idMusica) {

        Optional<Musica> optionalMusica = repositorioMusica.findById(idMusica);
       
        if(optionalMusica.isEmpty()){
            throw new InputMismatchException("Jogador não encontrado com o ID: " + idMusica);
        }
        MusicaDTO musicaDto = new ModelMapper().map(optionalMusica.get(), MusicaDTO.class);
        return Optional.of(musicaDto);
    }

    @Override
    public MusicaDTO adicionar(MusicaDTO musicaDto) {
       
        ModelMapper mapper = new ModelMapper();
        Musica musica = mapper.map(musicaDto, Musica.class);
       
        musica.setId(null);
        musica = repositorioMusica.save(musica);
        
        return mapper.map(musica, MusicaDTO.class);
    }

    @Override
    public void deletar(String idMusica) {

        repositorioMusica.deleteById(idMusica);
    }

    @Override
    public Musica atualizar(String idMusica, Musica musica) {

        musica.setId(idMusica);

        return repositorioMusica.save(musica);        
    }
}
