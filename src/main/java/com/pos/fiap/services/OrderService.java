package com.pos.fiap.services;

import com.pos.fiap.Enums.Status;
import com.pos.fiap.dto.OrderDTO;
import com.pos.fiap.entities.OrderItems;
import com.pos.fiap.entities.Orders;
import com.pos.fiap.repository.OrderItemsRepository;
import com.pos.fiap.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;
    public OrderService(OrderRepository orderRepository, OrderItemsRepository orderItemsRepository) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
    }

    @Transactional
    public List<OrderDTO> buscarPedidos(){
        List<Orders> pedidos = orderRepository.findAll();
        List<OrderDTO> pedidosDTO = new ArrayList<>();
        for(Orders pedido:pedidos){
            pedidosDTO.add(new OrderDTO(pedido));
        }
        return pedidosDTO;
    }

    @Transactional
    public OrderDTO criaPedido(OrderDTO orderDTO){
        Orders order = new Orders(orderDTO.getClientId(), orderDTO.getStatus());
        orderRepository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public void adicionarItensAoPedido(Long pedidoId, Map<Long, Integer> itensPedido) {
        Orders pedido = orderRepository.findById(pedidoId).orElseThrow(EntityNotFoundException::new);
        OrderItems itemPedido = new OrderItems();
        for (Map.Entry<Long, Integer> entry : itensPedido.entrySet()) {
            Long produtoId = entry.getKey();
            int quantidade = entry.getValue();

            itemPedido.setOrder(pedido);
            itemPedido.setProductId(produtoId);
            itemPedido.setQuantidade(quantidade);

            pedido.getItens().add(itemPedido);
        }

        orderRepository.save(pedido);
        orderItemsRepository.save(itemPedido);
    }

    @Transactional
    public OrderDTO alterarStatusPedido(Long pedidoId, Status status){
        Orders pedido = orderRepository.findById(pedidoId).orElseThrow(EntityNotFoundException::new);
        pedido.setStatus(status);
        orderRepository.save(pedido);
        return new OrderDTO(pedido);
    }
}
