package org.example.productmanagement2.product.service.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.productmanagement2.product.model.Product;
import org.springframework.stereotype.Component;
import vn.saolasoft.base.service.dto.DtoCreate;

@Component
public class ProductDtoCreate extends DtoCreate<Product, Long> {

    private String productName;
    private double price;

    private Long categoryId;

    ProductDtoCreate() {
        super();
    }

    ProductDtoCreate(String productName, double price, Long categoryId) {
        this.setId(this.getId());
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
    }

    @Override
    public Product toEntry() {
        Product product = new Product();
        product.setId(this.getId());
        product.setProductName(productName);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        return product;
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
