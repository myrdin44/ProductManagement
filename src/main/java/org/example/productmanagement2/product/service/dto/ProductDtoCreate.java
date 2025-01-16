package org.example.productmanagement2.product.service.dto;

import org.example.productmanagement2.product.model.Product;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;
import vn.saolasoft.base.service.dto.DtoCreate;

import java.io.Serial;

@Component
public class ProductDtoCreate extends DtoCreate<Product, String> {
    @Serial
    private static final long serialVersionUID = 1L;

    @UuidGenerator( style = UuidGenerator.Style.RANDOM)
    private String sku;

    private String productName;
    private double price;

    private String categoryId;

    ProductDtoCreate() {}

    ProductDtoCreate(String sku, String productName, double price, String categoryId) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
    }

    @Override
    public Product toEntry() {
        Product product = new Product();
        product.setSku(sku);
        product.setProductName(productName);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        return product;
    }

    @Override
    public String getId() {
        return "";
    }
}
