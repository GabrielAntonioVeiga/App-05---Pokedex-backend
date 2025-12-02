package com.example.pokedex.service;

import com.example.pokedex.dto.PokemonDto;
import com.example.pokedex.entity.Pokemon;
import com.example.pokedex.entity.Usuario;
import com.example.pokedex.repository.AutenticacaoRepository;
import com.example.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private AutenticacaoRepository autenticacaoRepository;

    public PokemonDto salvar(PokemonDto dto) {

        if (pokemonRepository.existsByNome(dto.getNome())) {
            dto.setMensagemErro("Já existe um pokémon cadastrado com esse nome.");
            return dto;
        }

        Pokemon pokemon = new Pokemon();
        pokemon.setNome(dto.getNome());
        pokemon.setTipo(dto.getTipo());
        pokemon.setHabilidades(dto.getHabilidades());

        Usuario usuarioValido = autenticacaoRepository.findByEmail(dto.getEmailusuario());
        pokemon.setUsuarioCadastrador(usuarioValido);

        Pokemon pokemonSalvo = pokemonRepository.save(pokemon);
        dto.setId(pokemonSalvo.getId());
        dto.setUsuarioCadastrador(usuarioValido);
        return dto;
    }

    public java.util.List<PokemonDto> listarTodos() {
        java.util.List<Pokemon> pokemons = pokemonRepository.findAll();
        return pokemons.stream().map(pokemon -> {
            PokemonDto dto = new PokemonDto();
            dto.setId(pokemon.getId());
            dto.setNome(pokemon.getNome());
            dto.setTipo(pokemon.getTipo());
            dto.setHabilidades(pokemon.getHabilidades());
            dto.setEmailusuario(pokemon.getUsuarioCadastrador().getEmail());
            return dto;
        }).collect(java.util.stream.Collectors.toList());
    }

    public PokemonDto editar(Long id, PokemonDto dto) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokémon não encontrado"));

        if (!pokemon.getNome().equals(dto.getNome()) && pokemonRepository.existsByNome(dto.getNome())) {
            dto.setMensagemErro("Já existe um pokémon cadastrado com esse nome.");
            return dto;
        }

        pokemon.setNome(dto.getNome());
        pokemon.setTipo(dto.getTipo());
        pokemon.setHabilidades(dto.getHabilidades());

        Pokemon pokemonAtualizado = pokemonRepository.save(pokemon);
        dto.setId(pokemonAtualizado.getId());
        dto.setEmailusuario(pokemonAtualizado.getUsuarioCadastrador().getEmail());
        return dto;
    }

    public void deletar(Long id) {
        if (!pokemonRepository.existsById(id)) {
            throw new RuntimeException("Pokémon não encontrado");
        }
        pokemonRepository.deleteById(id);
    }

    public List<String> findAllByHabilidade(String habilidade) {
      List<Pokemon> pokemons = pokemonRepository.findAllByHabilidadesContainingIgnoreCase(habilidade);
      return pokemons.stream().map(Pokemon::getNome).toList();
    }

    public List<String> findAllByTipo(String tipo) {
      List<Pokemon> pokemons = pokemonRepository.findAllByTipoContainingIgnoreCase(tipo);
      return pokemons.stream().map(Pokemon::getNome).toList();
    }
}
