package org.example.productmanagement2.product.service.dto;

import org.example.productmanagement2.product.model.Product;
import vn.saolasoft.base.service.dto.DtoUpdate;

public class ProductDtoUpdate extends DtoUpdate<Product, String> {

    private String sku;
    private String productName;
    private double price;
    private String categoryId;

    public ProductDtoUpdate() {}

    public ProductDtoUpdate(String sku, String productName, double price, String categoryId) {
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

    @Override
    public boolean apply(Product product) {
        if(!product.getId().equals(sku)
        || !product.getProductName().equals(productName)
            || product.getPrice() != price
            || !product.getCategoryId().equals(categoryId)
        ) {
            return false;
        }
        return true;
    }
}
