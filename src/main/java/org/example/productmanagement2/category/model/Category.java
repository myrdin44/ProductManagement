package org.example.productmanagement2.category.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.example.productmanagement2.product.model.Product;
import org.hibernate.annotations.UuidGenerator;
import vn.saolasoft.base.persistence.model.AuditableGeneratedIDEntry;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends AuditableGeneratedIDEntry {
    private static final long serialVersionUID = 1L;

    @UuidGenerator( style = UuidGenerator.Style.RANDOM)
    @Column(name = "category_id", unique = true)
    private String categoryId;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    private String categoryName;
    private String description;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
