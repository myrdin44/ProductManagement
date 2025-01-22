package org.example.productmanagement2.Modules.Category.service.impl;

import jakarta.transaction.Transactional;
import org.example.productmanagement2.Modules.Category.model.Category;
import org.example.productmanagement2.Modules.Category.repository.CategoryRepository;
import org.example.productmanagement2.Modules.Category.service.CategoryDtoService;
import org.example.productmanagement2.Modules.Category.service.dto.CategoryDtoGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.persistence.repository.AuditableRepository;
import vn.saolasoft.base.service.impl.AuditableDtoJpaServiceImpl;

import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class CategoryJpaServiceImpl extends AuditableDtoJpaServiceImpl<CategoryDtoGet, Category, Long> implements CategoryDtoService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDtoGet convert(Category category) {
        if (category != null) {
            CategoryDtoGet dto = new CategoryDtoGet();
            dto.setId(category.getId());
            dto.setCategoryName(category.getCategoryName());
            dto.setCategoryDescription(category.getDescription());

            return dto;
        }

        return null;
    }

    public CategoryJpaServiceImpl() {
        super();
    }

    @Override
    public AuditableRepository<Category, Long> getRepository() {
        return categoryRepository;
    }

    @Override
    public Set<String> getSortableColumns() {
        Set<String> sortableColumns = new HashSet<String>();
        sortableColumns.add("categoryName");
        sortableColumns.add("id");

        return sortableColumns;

    }
}
