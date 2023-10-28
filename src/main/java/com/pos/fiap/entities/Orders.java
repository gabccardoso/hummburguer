package com.pos.fiap.entities;

import com.pos.fiap.Enums.Status;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_db")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private Status status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    private List<OrderItems> itens;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    public Orders() {
    }

    public Orders(Long clientId, Status status) {
        this.clientId = clientId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderItems> getItens() {
        return itens;
    }

    public void setItens(List<OrderItems> itens) {
        this.itens = itens;
    }
    @PrePersist
    protected void onCreate() {
        this.dataCriacao = new Date();
    }
}
