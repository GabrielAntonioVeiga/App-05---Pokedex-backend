package com.example.pokedex.repository;

import com.example.pokedex.dto.TipoCountProjection;
import com.example.pokedex.entity.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {

    @Query(
            value =
                    """
                    SELECT 
                        h.nome AS tipo, 
                        COUNT(h.nome) AS quantidade 
                    FROM 
                        habilidades h  -- Use o nome da tabela no SQL nativo
                    GROUP BY 
                        h.nome 
                    ORDER BY 
                        quantidade DESC 
                    LIMIT 3
                    """,
            nativeQuery = true
    )
    List<TipoCountProjection> findTop3TiposWithCount();
}
