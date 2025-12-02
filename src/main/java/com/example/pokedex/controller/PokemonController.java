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
import java.util.Set;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<PokemonDto> login(@RequestBody PokemonDto dto) {
        return ResponseEntity.ok(pokemonService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<PokemonDto>> listarTodos() {
        return ResponseEntity.ok(pokemonService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonDto> editar(@PathVariable Long id, @RequestBody PokemonDto dto) {
        return ResponseEntity.ok(pokemonService.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pokemonService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-habilidade")
    public ResponseEntity<Set<String>> findAllByHabilidade(@RequestParam String habilidade) {
        return ResponseEntity.ok(pokemonService.findByHabilidade(habilidade));
    }

    @GetMapping("/by-tipo")
    public ResponseEntity<List<String>> findAllByTipo(@RequestParam String tipo) {
        return ResponseEntity.ok(pokemonService.findAllByTipo(tipo));
    }
    @GetMapping("/count")
    public ResponseEntity<Integer> count() {
        return ResponseEntity.ok(pokemonService.contarPokemons());
    }

    @GetMapping("/top/tipos")
    public ResponseEntity<?> getTopTipos() {
        return ResponseEntity.ok(pokemonService.getTopTipos());
    }

    @GetMapping("/top/habilidades")
    public ResponseEntity<?> getTopHabilidades() {
        return ResponseEntity.ok(pokemonService.getTopHabilidades());
    }

}
