package com.pos.fiap.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "orderItems_db")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Orders order;

    @Column(name = "produto_id")
    private Long productId;
    private int quantidade;

    public OrderItems(Long id, Orders order, Long productId, int quantidade) {
        this.id = id;
        this.order = order;
        this.productId = productId;
        this.quantidade = quantidade;
    }

    public OrderItems() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
