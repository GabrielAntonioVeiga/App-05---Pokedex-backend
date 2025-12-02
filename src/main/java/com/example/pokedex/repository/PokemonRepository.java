package com.example.pokedex.repository;

import com.example.pokedex.dto.TipoCountProjection;
import com.example.pokedex.entity.Pokemon;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    boolean existsByNome(String nome);


  @Query(
      value = """
        SELECT p.*
        FROM pokemons p
        JOIN habilidades h ON h.pokemon_id = p.id
        WHERE LOWER(h.nome) LIKE LOWER(CONCAT('%', :habilidade, '%'))
    """,
      nativeQuery = true
  )
  List<Pokemon> buscarPorHabilidade(@Param("habilidade") String habilidade);

  List<Pokemon> findAllByTipoContainingIgnoreCase(String tipo);


    @Query(
            value =
                    """
                    SELECT 
                        p.tipo AS tipo, 
                        COUNT(p.tipo) AS quantidade 
                    FROM 
                        pokemons p  -- Use o nome da tabela no SQL nativo
                    GROUP BY 
                        p.tipo 
                    ORDER BY 
                        quantidade DESC 
                    LIMIT 3
                    """,
            nativeQuery = true
    )
    List<TipoCountProjection> findTop3TiposWithCount();
}
