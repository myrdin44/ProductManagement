package org.example.productmanagement2.Product.query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.productmanagement2.Product.model.Product;
import vn.saolasoft.base.service.filter.BaseFilter;
import vn.saolasoft.base.service.filter.PaginationInfo;

import java.util.ArrayList;
import java.util.List;

public class SearchQuery extends BaseFilter<Product, Long> {
    private String productName;
    private Long categoryId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        //search by productName
        if(productName != null && !productName.isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get("productName")), "%" + productName.toLowerCase() + "%"));
            System.out.print("Returned Product: " + productName + "       ");
        }

        //search by categoryId
        if(categoryId != null) {
            predicates.add(builder.equal(root.get("categoryId"), categoryId));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
