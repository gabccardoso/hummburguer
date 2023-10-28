package com.pos.fiap.controllers;

import com.pos.fiap.Enums.Categorias;
import com.pos.fiap.dto.ProductDTO;
import com.pos.fiap.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "buscarProdutoPorCategoria")
    public ResponseEntity<List<ProductDTO>> buscarPorCategoria(@RequestParam String categoriaBuscada){
        Categorias categoria = Categorias.valueOf(categoriaBuscada.toUpperCase());
        return ResponseEntity.ok(productService.buscaPorCategoria(categoria));
    }

    @GetMapping(value = "buscarProdutos")
    public ResponseEntity<List<ProductDTO>> buscarProdutos(){
        return ResponseEntity.ok(productService.buscaProdutos());
    }

    @PutMapping(value = "editarProduto/{id}")
    public ResponseEntity<ProductDTO> editarProduto(@RequestBody ProductDTO productDTO, @PathVariable Long id){
        return ResponseEntity.ok(productService.editarProduto(id, productDTO));
    }

    @PostMapping(value = "criarProduto")
    public ResponseEntity<ProductDTO> criarProduto(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.criaProduto(productDTO));
    }

    @DeleteMapping(value = "deletarProduto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        productService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }


}
