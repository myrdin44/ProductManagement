package org.example.productmanagement2.category.repository;

import org.example.productmanagement2.category.model.Category;
import org.springframework.stereotype.Repository;
import vn.saolasoft.base.persistence.repository.AuditableRepository;

@Repository
public interface CategoryRepository extends AuditableRepository<Category, String> {
}
