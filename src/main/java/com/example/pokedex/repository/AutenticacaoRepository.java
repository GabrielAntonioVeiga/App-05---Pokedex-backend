package com.example.pokedex.repository;

import com.example.pokedex.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutenticacaoRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmailAndSenha(String email, String senha);

    Usuario findByEmail(String email);
}
