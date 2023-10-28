package com.pos.fiap.controllers;

import com.pos.fiap.Enums.Status;
import com.pos.fiap.dto.OrderDTO;
import com.pos.fiap.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/pedido")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "buscarPedidos")
    public ResponseEntity<List<OrderDTO>> buscarPedidos(){
        return ResponseEntity.ok(orderService.buscarPedidos());
    }

    @PostMapping(value = "criarPedido")
    public ResponseEntity<OrderDTO> criarPedido(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(orderService.criaPedido(orderDTO));
    }

    @PostMapping(value = "adicionarItens/{pedidoId}")
    public ResponseEntity<String> adicionarItensAoPedido(
            @PathVariable Long pedidoId,
            @RequestBody Map<Long, Integer> itensPedido
    ) {
        orderService.adicionarItensAoPedido(pedidoId, itensPedido);
        return ResponseEntity.ok("Itens adicionados com sucesso");
    }

    @PutMapping(value = "alterarStatusPedido/{pedidoId}")
    public ResponseEntity<OrderDTO> alterarStatusPedido(@PathVariable Long pedidoId, @RequestParam String status){
        Status statusNovo = Status.valueOf(status.toUpperCase());
        return ResponseEntity.ok(orderService.alterarStatusPedido(pedidoId, statusNovo));
    }
}
