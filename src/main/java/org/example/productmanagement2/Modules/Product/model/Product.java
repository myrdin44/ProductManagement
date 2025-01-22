package org.example.productmanagement2.Modules.Product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.example.productmanagement2.Modules.Category.model.Category;
import vn.saolasoft.base.persistence.model.AuditableGeneratedIDEntry;

@Entity
@Table(name = "products")
public class Product extends AuditableGeneratedIDEntry {

    private String productName;

    private double price;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category = new Category();

    public Product() {}

    public Product(String productName, double price, Long categoryId) {
        this.productName = productName;
        this.price = price;
        this.category = new Category();
        this.category.setId(categoryId);
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

    public Long getCategoryId() {
        return category.getId();
    }

    public void setCategoryId(Long categoryId) {
        this.category.setId(categoryId);
    }

}
