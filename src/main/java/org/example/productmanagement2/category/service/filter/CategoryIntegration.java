package org.example.productmanagement2.category.service.filter;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.productmanagement2.category.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryIntegration {
    @Autowired
    private CategoryFilter filter;
    @Autowired
    private CategorySort sort;
    @Autowired
    private CategoryPaging paging;

    public CategoryIntegration(CategoryFilter filter, CategorySort sort, CategoryPaging paging) {
        this.filter = filter;
        this.sort = sort;
        this.paging = paging;
    }

    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return filter.toPredicate(root, query, builder);
    }

    public void applySorting(CriteriaQuery<?> query, CriteriaBuilder builder, Root<Category> root) {
        sort.applySorting(query, root, builder);
    }

    public void applyPaging(Query query) {
        paging.applyPaging(query);
    }

}
