package com.example.demo.repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
