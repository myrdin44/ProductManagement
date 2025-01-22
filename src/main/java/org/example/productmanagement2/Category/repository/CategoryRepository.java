package org.example.productmanagement2.Category.repository;

import org.example.productmanagement2.Category.model.Category;
import org.springframework.stereotype.Repository;
import vn.saolasoft.base.persistence.repository.AuditableRepository;

@Repository
public interface CategoryRepository extends AuditableRepository<Category, Long> {
}
