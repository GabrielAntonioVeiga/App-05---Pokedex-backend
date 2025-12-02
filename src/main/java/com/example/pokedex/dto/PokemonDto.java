package com.example.pokedex.dto;

import com.example.pokedex.entity.Usuario;
import jakarta.persistence.*;

import java.util.List;

public class PokemonDto {

    private Long id;

    private String nome;

    private String tipo;

    private List<String> habilidades;

    private String emailusuario;

    private Usuario usuarioCadastrador;

    private String mensagemErro;

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

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public Usuario getUsuarioCadastrador() {
        return usuarioCadastrador;
    }

    public void setUsuarioCadastrador(Usuario usuarioCadastrador) {
        this.usuarioCadastrador = usuarioCadastrador;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }
}
