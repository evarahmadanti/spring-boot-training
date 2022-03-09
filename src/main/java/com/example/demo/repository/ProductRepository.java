package com.example.demo.repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
//    @Query(value = "Select name from ProductEntity where ")
    // JPQL
    List<ProductEntity> findByStockGreaterThan(long jumlah);
//    List<ProductEntity> findByStockEquals(long jumlah);
//    List<ProductEntity> findByStockAndNameOrderByNameDesc(long jumlah, String nama);
}
