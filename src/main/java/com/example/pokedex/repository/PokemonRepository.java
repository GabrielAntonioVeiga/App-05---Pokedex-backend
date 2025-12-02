package com.example.pokedex.repository;

import com.example.pokedex.entity.Pokemon;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    boolean existsByNome(String nome);
}
