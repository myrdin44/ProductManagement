package org.example.productmanagement2.Category.service.dto;

import org.example.productmanagement2.Category.model.Category;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.service.dto.DtoGet;

@Service
public class CategoryDtoGet extends DtoGet<Category, Long> {

    private String categoryName;
    private String categoryDescription;

    public CategoryDtoGet() {}

    @Override
    public void parse(Category category) {
        this.setId(category.getId());
        this.categoryName = category.getCategoryName();
        this.categoryDescription = category.getDescription();
    }

    public CategoryDtoGet(String categoryName, String categoryDescription) {
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
