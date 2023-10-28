package com.pos.fiap.entities;


import com.pos.fiap.Enums.Categorias;
import com.pos.fiap.Enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Categorias categoria;
    private String descricao;
    private String imagem;
    private Double preco;

    public Product() {
    }

    public Product(String nome, Categorias categoria, String descricao, String imagem, Double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
    }

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

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
