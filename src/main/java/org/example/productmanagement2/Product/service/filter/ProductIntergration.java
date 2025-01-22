package org.example.productmanagement2.Product.service.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.productmanagement2.Product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductIntergration {
    @Autowired
    private ProductFilter filter;

    @Autowired
    private ProductPaging paging;

    @Autowired
    private ProductSort sort;

    ProductIntergration() {}

    ProductIntergration(ProductFilter filter, ProductSort sort, ProductPaging paging) {
        this.filter = filter;
        this.sort = sort;
        this.paging = paging;
    }

    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return filter.toPredicate(root, query, builder);
    }

    public void applySorting(CriteriaQuery<?> query, CriteriaBuilder builder, Root<Product> root) {
        sort.applySorting(query, root, builder);
    }

    public void applyPaging(jakarta.persistence.Query query) {
        paging.applyPaging(query);
    }
}
