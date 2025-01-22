package org.example.productmanagement2.Modules.Category.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.example.productmanagement2.Modules.Product.model.Product;
import vn.saolasoft.base.persistence.model.AuditableSerialIDEntry;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends AuditableSerialIDEntry {

    private String categoryName;
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    public Category() {}

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
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

    public Category(Long id) {
        super(id);
    }

}
