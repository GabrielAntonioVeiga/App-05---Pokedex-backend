package com.example.pokedex.repository;

import com.example.pokedex.entity.Pokemon;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    boolean existsByNome(String nome);
    List<Pokemon> findAllByHabilidadesContainingIgnoreCase(String habilidades);
    List<Pokemon> findAllByTipoContainingIgnoreCase(String tipo);

}
