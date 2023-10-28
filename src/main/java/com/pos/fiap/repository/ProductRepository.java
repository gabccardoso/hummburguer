package com.pos.fiap.repository;

import com.pos.fiap.Enums.Categorias;
import com.pos.fiap.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoria(Categorias categoria);
}
