package org.example.productmanagement2.product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.example.productmanagement2.category.model.Category;
import vn.saolasoft.base.persistence.model.AuditableDbEntry;

import java.util.Date;

@Entity
@Table(name = "products")
public class Product extends AuditableDbEntry<Long> {

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

    @Override
    public Long getCreator() {
        return super.getCreator();
    }

    @Override
    public void setCreator(Long creator) {
        super.setCreator(creator);
    }

    @Override
    public Date getDateCreated() {
        return super.getDateCreated();
    }

    @Override
    public void setDateCreated(Date dateCreated) {
        super.setDateCreated(dateCreated);
    }

    @Override
    public Date getDateUpdated() {
        return super.getDateUpdated();
    }

    @Override
    public void setDateUpdated(Date dateUpdated) {
        super.setDateUpdated(dateUpdated);
    }

    @Override
    public Long getUpdater() {
        return super.getUpdater();
    }

    @Override
    public void setUpdater(Long updater) {
        super.setUpdater(updater);
    }

}
