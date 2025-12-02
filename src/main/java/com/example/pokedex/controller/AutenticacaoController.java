package com.example.pokedex.controller;

import com.example.pokedex.dto.UsuarioDto;
import com.example.pokedex.service.AutenticacaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UsuarioDto dto) {
        return ResponseEntity.ok(autenticacaoService.autenticar(dto.getEmail(), dto.getSenha()));
    }

}
