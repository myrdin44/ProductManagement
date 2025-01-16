package org.example.productmanagement2.product.service.dto;

import org.example.productmanagement2.product.model.Product;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;
import vn.saolasoft.base.service.dto.DtoGet;

import java.io.Serial;

@Component
public class ProductDtoGet extends DtoGet<Product, String> {
    @Serial
    private static final long serialVersionUID = 1L;

    @UuidGenerator( style = UuidGenerator.Style.RANDOM)
    private String sku;

    private String productName;
    private double price;
    private String categoryId;

    public ProductDtoGet() {}

    @Override
    public void parse(Product product) {
            this.setSku(product.getSku());
            this.setProductName(product.getProductName());
            this.setPrice(product.getPrice());
            this.setCategoryId(product.getCategoryId());
    }

    public ProductDtoGet(String sku, String productName, double price, String categoryId) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
