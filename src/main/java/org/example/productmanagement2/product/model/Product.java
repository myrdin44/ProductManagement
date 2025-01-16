package org.example.productmanagement2.product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.example.productmanagement2.category.model.Category;
import org.hibernate.annotations.UuidGenerator;
import vn.saolasoft.base.persistence.model.AuditableGeneratedIDEntry;
import vn.saolasoft.base.persistence.model.interfaces.BaseEntity;

import java.io.Serial;

@Entity
@Table(name = "product")
public class Product extends AuditableGeneratedIDEntry implements BaseEntity<String> {

    @Serial
    private static final long serialVersionUID = 1L;


    @UuidGenerator( style = UuidGenerator.Style.RANDOM)
    private String sku;


    private String productName;

    private double price;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    public Product() {}

    public Product(String sku, String productName, double price, String categoryId) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.category = new Category();
        this.category.setCategoryId(categoryId);
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCategoryId() {
        return category.getCategoryId();
    }

    public void setCategoryId(String categoryId) {
        this.category.setCategoryId(categoryId);
    }
}
