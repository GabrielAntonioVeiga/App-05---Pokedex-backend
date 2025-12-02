package com.example.pokedex.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "usuario_cadastrador_id")
    private Usuario usuarioCadastrador;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemon_id")
    private List<Habilidade> listaHabilidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuarioCadastrador() {
        return usuarioCadastrador;
    }

    public void setUsuarioCadastrador(Usuario usuarioCadastrador) {
        this.usuarioCadastrador = usuarioCadastrador;
    }

    public List<Habilidade> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(List<Habilidade> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }
}
