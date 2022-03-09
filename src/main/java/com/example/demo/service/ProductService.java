package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UpdateStockDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

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

    public List<ProductEntity> fetch(boolean isInStock){
        if (isInStock) {
            return fetchAllIsInStock();
        } else {
            return fetchAll();
        }
    }

    public List<ProductEntity> fetchFilter(long maxPrice){
        return fetchAllIsUnderPrice(maxPrice);
    }

    public List<ProductEntity> fetchAllIsUnderPrice( long maxPrice){
        return productRepository.findByPriceLessThanEqual(maxPrice);
    }

    public List<ProductEntity> fetchAllIsInStock(){
        return productRepository.findByStockGreaterThan(10);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public ProductEntity getById(long id) {
        return productRepository.findById(id).orElse(new ProductEntity());
    }

    public ProductEntity updateStock(UpdateStockDto request) {
        // get product by id in DB
        ProductEntity product = getById((request.getId()));

        // update stock
        long currentStock = product.getStock();
        long updatedStock = currentStock = currentStock + request.getNumberOfStock();
        product.setStock(updatedStock);

        // save updated data to DB
        return productRepository.save(product);
    }
}
