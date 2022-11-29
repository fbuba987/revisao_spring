package com.generation.loja_de_games.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull( message = "O Id e obrigatorio")
    private Long id;

    @NotBlank(message = "O nome título é Obrigatório e não pode utilizar espaços em branco!")
    @Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres")
    private String nome;
    @NotBlank(message = "A descricao nome é Obrigatório e não pode utilizar espaços em branco!")
    @Size(min = 10, max = 255, message = "A descricao deve conter no mínimo 05 e no máximo 100 caracteres")
    private String descricao;

    @NotNull
    private float preco;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
