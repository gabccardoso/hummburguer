package com.pos.fiap.services;

import com.pos.fiap.Enums.Categorias;
import com.pos.fiap.dto.ProductDTO;
import com.pos.fiap.entities.Product;
import com.pos.fiap.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public List<ProductDTO> buscaPorCategoria(Categorias categoria){
        List<Product> productList = productRepository.findByCategoria(categoria);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product : productList){
            productDTOList.add(new ProductDTO(product));
        }
        return productDTOList;
    }

    @Transactional
    public ProductDTO criaProduto(ProductDTO productDTO){
        Product product = new Product(productDTO.getNome(), productDTO.getCategoria(), productDTO.getDescricao(),
                productDTO.getImagem(), productDTO.getPreco());
        productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO editarProduto(Long id, ProductDTO productDTO){
        Product product = productRepository.getReferenceById(id);
        product.setImagem(productDTO.getImagem());
        product.setNome(productDTO.getNome());
        product.setDescricao(productDTO.getDescricao());
        product.setCategoria(productDTO.getCategoria());
        product.setPreco(productDTO.getPreco());
        productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public void excluirProduto(Long id){
        productRepository.deleteById(id);
    }

    @Transactional
    public List<ProductDTO> buscaProdutos(){
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product:productList){
            productDTOList.add(new ProductDTO(product));
        }
        return productDTOList;
    }



}
