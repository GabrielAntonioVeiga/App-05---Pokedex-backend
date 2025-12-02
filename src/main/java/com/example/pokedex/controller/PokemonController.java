package com.example.pokedex.controller;

import com.example.pokedex.dto.PokemonDto;
import com.example.pokedex.dto.UsuarioDto;
import com.example.pokedex.entity.Pokemon;
import com.example.pokedex.service.AutenticacaoService;
import com.example.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<PokemonDto> login(@RequestBody PokemonDto dto) {
        return ResponseEntity.ok(pokemonService.salvar(dto));
    }
}
