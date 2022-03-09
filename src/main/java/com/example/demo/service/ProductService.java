package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {
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

    public List<ProductEntity> fetchAll() {
//        List<ProductEntity> result = ArrayList<>();
//        Iterable<ProductEntity> prods = ProductEntity.findAll();
//        stream prod masukin ke result
        return (List<ProductEntity>) productRepository.findAll(); // ngambil dan balikin semua data yang ada di DB
        // Find All balikannya itu iterable
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
