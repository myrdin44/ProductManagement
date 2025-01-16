package org.example.productmanagement2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import vn.saolasoft.base.persistence.model.AuditableGeneratedIDEntry;
import vn.saolasoft.base.persistence.model.interfaces.BaseEntity;

import java.io.Serial;

@Entity
@Table(name = "product")
public class Product extends AuditableGeneratedIDEntry implements BaseEntity<String> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    @UuidGenerator( style = UuidGenerator.Style.RANDOM)
    private String sku;

    @Setter
    @Getter
    private String productName;
    @Setter
    @Getter
    private double price;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    @Setter
    @Getter
    private String categoryId = category.getCategoryId();

    public Product() {}

    public Product(String sku, String productName, double price, String categoryId) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.category = new Category();
        this.categoryId = categoryId;
    }

}
