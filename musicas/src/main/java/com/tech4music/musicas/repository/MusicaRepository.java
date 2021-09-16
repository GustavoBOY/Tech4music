package com.tech4music.musicas.repository;

import com.tech4music.musicas.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends MongoRepository<Musica, String>{
    
}
