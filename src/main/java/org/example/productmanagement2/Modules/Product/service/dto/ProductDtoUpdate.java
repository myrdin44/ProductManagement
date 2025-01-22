package org.example.productmanagement2.Modules.Product.service.dto;

import org.example.productmanagement2.Modules.Product.model.Product;
import vn.saolasoft.base.service.dto.DtoUpdate;

public class ProductDtoUpdate extends DtoUpdate<Product, String> {

    private String productName;
    private double price;
    private Long categoryId;

    public ProductDtoUpdate() {}

    public ProductDtoUpdate(String productName, double price, Long categoryId) {
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

    @Override
    public boolean apply(Product product) {
        boolean isModified = false;

        if (productName != null && !productName.equals(product.getProductName())) {
            product.setProductName(productName);
            isModified = true;
        }
        if (categoryId != null && !categoryId.equals(product.getCategoryId())) {
            product.setCategoryId(categoryId);
            isModified = true;
        }
        if (price != product.getPrice()) {
            product.setPrice(price);
            isModified = true;
        }

        return isModified;
    }

}
