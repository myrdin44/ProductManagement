package org.example.productmanagement2.service.dto;

import org.example.productmanagement2.model.Category;
import vn.saolasoft.base.service.dto.DtoCreate;

public class CategoryDtoCreate extends DtoCreate<Category, String> {

    private String categoryId;
    private String categoryName;
    private String categoryDescription;

    CategoryDtoCreate() {}

    CategoryDtoCreate(String categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    @Override
    public Category toEntry() {
        Category category = new Category();

        category.setCategoryId(categoryId);
        category.setCategoryName(categoryName);
        category.setDescription(categoryDescription);

        return category;
    }


}
