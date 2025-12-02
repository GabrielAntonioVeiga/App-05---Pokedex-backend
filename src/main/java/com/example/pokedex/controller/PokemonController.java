package com.example.pokedex.controller;

import com.example.pokedex.dto.PokemonDto;
import com.example.pokedex.dto.UsuarioDto;
import com.example.pokedex.entity.Pokemon;
import com.example.pokedex.service.AutenticacaoService;
import com.example.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<PokemonDto> login(@RequestBody PokemonDto dto) {
        return ResponseEntity.ok(pokemonService.salvar(dto));
    }

    @GetMapping("/by-habilidade")
    public ResponseEntity<List<String>> findAllByHabilidade(@RequestParam String habilidade) {
        return ResponseEntity.ok(pokemonService.findAllByHabilidade(habilidade));
    }

    @GetMapping("/by-tipo")
    public ResponseEntity<List<String>> findAllByTipo(@RequestParam String tipo) {
        return ResponseEntity.ok(pokemonService.findAllByHabilidade(tipo));
    }
}
