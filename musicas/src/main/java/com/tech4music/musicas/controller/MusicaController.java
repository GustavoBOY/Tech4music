package com.tech4music.musicas.controller;



//#region import java util
import java.util.List;
import java.util.Optional;
//#endregion


//#region import Tech4music
import com.tech4music.musicas.services.MusicaServiceImpl;
import com.tech4music.musicas.model.Musica;
import com.tech4music.musicas.shared.MusicaDTO;
//#endregion

//#region import springframework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//#endregion

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    
    @Autowired
    MusicaServiceImpl servicoMusica;

    //listar todas as músicas
    @GetMapping
    public ResponseEntity<List<MusicaDTO>> obterTodos(){
        
        List<MusicaDTO> musicas = servicoMusica.obterTodos();
        return new ResponseEntity<>(musicas, HttpStatus.OK);
    }

    //listar músicas pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<MusicaDTO>> obterPorId(@PathVariable String id){
        
        Optional<MusicaDTO> musica = servicoMusica.obterPorId(id);
        return new ResponseEntity<>(musica, HttpStatus.OK);
    }

    //adicionar música
    @PostMapping
    public ResponseEntity<MusicaDTO> adicionar(@RequestBody MusicaDTO musicaDto){

        musicaDto = servicoMusica.adicionar(musicaDto);
        return new ResponseEntity<>(musicaDto, HttpStatus.CREATED);
    }

    //deletar música
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){

        servicoMusica.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //atualizar música
    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@PathVariable String id, @RequestBody MusicaDTO musicaDto){

        return new ResponseEntity<>(servicoMusica.atualizar(id, musicaDto), HttpStatus.OK);
    }

}
