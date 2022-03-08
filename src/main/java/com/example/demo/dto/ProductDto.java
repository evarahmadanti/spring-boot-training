package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {
    @JsonProperty("product-name")
    private String productName;

    @JsonProperty("harga")
    private long price;

    @JsonProperty("stok")
    private long stock;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}
