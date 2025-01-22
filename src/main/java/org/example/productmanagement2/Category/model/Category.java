package org.example.productmanagement2.Category.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.example.productmanagement2.Product.model.Product;
import vn.saolasoft.base.persistence.model.AuditableSerialIDEntry;

import java.util.ArrayList;
import java.util.Date;
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
