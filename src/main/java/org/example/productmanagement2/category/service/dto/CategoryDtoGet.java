package org.example.productmanagement2.category.service.dto;

import org.example.productmanagement2.category.model.Category;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.service.dto.DtoGet;

@Service
public class CategoryDtoGet extends DtoGet<Category, String> {

    private String categoryId;
    private String categoryName;
    private String categoryDescription;

    public CategoryDtoGet() {}

    @Override
    public void parse(Category category) {
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
        this.categoryDescription = category.getDescription();
    }

    public CategoryDtoGet(String categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
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
