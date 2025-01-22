package org.example.productmanagement2.Category.service.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.productmanagement2.Category.model.Category;
import org.springframework.stereotype.Component;
import vn.saolasoft.base.service.filter.BaseFilter;

@Component
public class CategoryFilter extends BaseFilter<Category, Long> {
    private String categoryName;
    private String categoryDescription;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        //use logic from baseFilter
        Predicate predicate = super.toPredicate(root, query, builder);

        //add criteria to filter by catName
        if (categoryName != null && !categoryName.isEmpty()) {
            predicate = (predicate == null) ? builder.like(root.get("categoryName"), "%" + categoryName + "%") : builder.and(predicate, builder.like(root.get("categoryName"), "%" + categoryName + "%"));
        }

        //add criteria to filter by des
        if (categoryDescription != null && !categoryDescription.isEmpty()) {
            predicate = (predicate == null) ? builder.like(root.get("description"), "%" + categoryDescription + "%") : builder.and(predicate, builder.like(root.get("description"), "%" + categoryDescription + "%"));
        }

        return predicate;
    }
}
