package com.pos.fiap.dto;

import com.pos.fiap.Enums.Status;
import com.pos.fiap.entities.Orders;

public class OrderDTO {

    private Long pedidoId;
    private Long clientId;
    private Status status;

    public OrderDTO(Long clientId, Status status, Long pedidoId) {
        this.pedidoId = pedidoId;
        this.clientId = clientId;
        this.status = status;
    }

    public OrderDTO(Orders order) {
        this.clientId = order.getClientId();
        this.status = order.getStatus();
        this.pedidoId = order.getId();
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

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
}
