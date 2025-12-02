package com.example.pokedex.service;

import com.example.pokedex.repository.AutenticacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private AutenticacaoRepository autenticacaoRepository;

    public boolean autenticar(String email, String senha) {
        return autenticacaoRepository.existsByEmailAndSenha(email, senha);
    }
}
