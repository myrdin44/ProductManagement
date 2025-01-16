package org.example.productmanagement2.service.dto;

import org.example.productmanagement2.model.Category;
import vn.saolasoft.base.service.dto.DtoGet;

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
}
