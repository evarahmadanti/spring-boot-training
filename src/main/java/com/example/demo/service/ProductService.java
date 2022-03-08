package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    Logger logger =
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity add(ProductDto request) {
        ProductEntity product = new ProductEntity();
        product.setName(request.getProductName());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());

        //todo:  Save into DB
        return productRepository.save(product);
    }
}
