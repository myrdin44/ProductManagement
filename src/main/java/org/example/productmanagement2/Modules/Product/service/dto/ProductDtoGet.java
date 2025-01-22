package org.example.productmanagement2.Modules.Product.service.dto;

import org.example.productmanagement2.Modules.Product.model.Product;
import org.springframework.stereotype.Component;
import vn.saolasoft.base.service.dto.DtoGet;

@Component
public class ProductDtoGet extends DtoGet<Product, String> {

    private String productName;
    private double price;
    private Long categoryId;

    public ProductDtoGet() {}

    @Override
    public void parse(Product product) {
            this.setId(product.getId());
            this.setProductName(product.getProductName());
            this.setPrice(product.getPrice());
            this.setCategoryId(product.getCategoryId());
    }

    public ProductDtoGet(String productName, double price, Long categoryId) {
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
