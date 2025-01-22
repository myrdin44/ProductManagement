package org.example.productmanagement2.Category.service.dto;

import org.example.productmanagement2.Category.model.Category;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.service.dto.DtoUpdate;

@Service
public class CategoryDtoUpdate extends DtoUpdate<Category, Long> {
    private String categoryName;
    private String categoryDescription;

    public CategoryDtoUpdate() {}

    @Override
    public boolean apply(Category category) {
        boolean isModified = false;

        if (categoryName != null) {
            category.setCategoryName(categoryName);
            isModified = true;
        }

        if (categoryDescription != null) {
            category.setDescription(categoryDescription);
            isModified = true;
        }

        return isModified;
    }

    public CategoryDtoUpdate(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
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
