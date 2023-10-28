package com.pos.fiap.dto;

import com.pos.fiap.Enums.Categorias;
import com.pos.fiap.Enums.Status;
import com.pos.fiap.entities.Product;

public class ProductDTO {

    private String nome;
    private Categorias categoria;
    private String descricao;
    private String imagem;
    private Double preco;
    private Long id;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        nome = product.getNome();
        categoria = product.getCategoria();
        descricao = product.getDescricao();
        imagem = product.getImagem();
        preco = product.getPreco();
        id = product.getId();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
