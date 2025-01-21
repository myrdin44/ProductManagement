package org.example.productmanagement2.product.service.dto;

import org.example.productmanagement2.product.model.Product;
import vn.saolasoft.base.service.dto.DtoUpdate;

public class ProductDtoUpdate extends DtoUpdate<Product, Long> {

    private Long uuid;
    private String productName;
    private double price;
    private String categoryId;

    public ProductDtoUpdate() {}

    public ProductDtoUpdate(Long id, String productName, double price, String categoryId) {
        this.uuid = id;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
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

    @Override
    public boolean apply(Product product) {
        if(product.getId() == this.getUuid() && product.getProductName().equals(productName)
            && product.getPrice() == price
            && product.getCategoryId().equals(categoryId)
        ) {
            return false;
        }
        return true;
    }
}
