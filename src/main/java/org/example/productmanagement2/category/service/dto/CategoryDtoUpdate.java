package org.example.productmanagement2.category.service.dto;

import org.example.productmanagement2.category.model.Category;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.service.dto.DtoUpdate;

@Service
public class CategoryDtoUpdate extends DtoUpdate<Category, Long> {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

    public CategoryDtoUpdate() {}

    @Override
    public boolean apply(Category category) {
        if (!category.getId().equals(categoryId)
                || !category.getCategoryName().equals(categoryName)
                || !category.getDescription().equals(categoryDescription) ) {
            category.setId(categoryId);
            category.setCategoryName(categoryName);
            category.setDescription(categoryDescription);
            return true;
        } else {
            return false;
        }
    }

    public CategoryDtoUpdate(Long categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

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


}
