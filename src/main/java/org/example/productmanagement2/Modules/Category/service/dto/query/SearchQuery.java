package org.example.productmanagement2.Modules.Category.service.dto.query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.productmanagement2.Modules.Category.model.Category;
import vn.saolasoft.base.service.filter.BaseFilter;
import java.util.ArrayList;
import java.util.List;

public class SearchQuery extends BaseFilter<Category, Long> {

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

    @Override
    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        //search by categoryName
        if(categoryName != null) {
            predicates.add(builder.like(builder.lower(root.get("categoryName")), "%" + categoryName.toLowerCase() + "%"));
            System.out.println("Returned categoryName : " + categoryName + "           ");
        }

        return predicates.isEmpty() ? null : builder.and(predicates.toArray(new Predicate[0]));
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

}
