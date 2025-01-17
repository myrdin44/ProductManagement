package org.example.productmanagement2.product.service.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.productmanagement2.product.model.Product;
import org.springframework.stereotype.Component;
import vn.saolasoft.base.service.filter.BaseFilter;

@Component
public class ProductFilter extends BaseFilter<Product, String> {
    private String productName;
    private double price;
    private String categoryType;

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
    public String getCategoryType() {
        return categoryType;
    }
    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Predicate predicate = super.toPredicate(root, query, builder);

        if (productName != null && !productName.isEmpty()) {
            predicate = (predicate == null) ? builder.like(root.get("productName"), "%" + productName + "%") : builder.and(predicate, builder.like(root.get("productName"), "%" + productName + "%"));
        }

        if (price != 0) {
            predicate = (predicate == null) ? builder.equal(root.get("price"), price) : builder.and(predicate, builder.equal(root.get("price"), price));
        }

        if (categoryType != null && !categoryType.isEmpty()) {
            predicate = (predicate == null) ? builder.equal(root.get("category_id"), categoryType) : builder.and(predicate, builder.equal(root.get("category_id"), categoryType));
        }

        return predicate;
    }
}
