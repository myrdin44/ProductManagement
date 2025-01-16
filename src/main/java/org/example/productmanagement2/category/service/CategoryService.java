package org.example.productmanagement2.category.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.productmanagement2.category.model.Category;
import org.example.productmanagement2.category.repository.CategoryRepository;
import org.example.productmanagement2.category.service.filter.CategoryIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getFilteredCategories(CategoryIntegration integrationCriteria) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);

        //apply predicate
        Predicate predicate = integrationCriteria.toPredicate(root, query, builder);
        query.where(predicate);

        //apply sotring
        integrationCriteria.applySorting(query, builder, root);

        //apply pagination
        TypedQuery<Category> jpaQuery = entityManager.createQuery(query);

        integrationCriteria.applyPaging(jpaQuery);

        return jpaQuery.getResultList();
    }
}
