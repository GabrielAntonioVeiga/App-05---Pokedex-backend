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

    public List<String> findAllByHabilidade(String habilidade) {
      List<Pokemon> pokemons = pokemonRepository.findAllByHabilidades(habilidade);
      return pokemons.stream().map(Pokemon::getNome).toList();
    }

    public List<String> findAllByTipo(String tipo) {
      List<Pokemon> pokemons = pokemonRepository.findAllByTipo(tipo);
      return pokemons.stream().map(Pokemon::getNome).toList();
    }
}
