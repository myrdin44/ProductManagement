package org.example.productmanagement2.service.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.productmanagement2.model.Product;
import org.hibernate.annotations.UuidGenerator;
import vn.saolasoft.base.service.dto.DtoGet;

import java.io.Serial;

@Setter
@Getter
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



}
