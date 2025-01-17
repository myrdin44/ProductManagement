package org.example.productmanagement2.category.service.dto;

import org.example.productmanagement2.category.model.Category;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.service.dto.DtoCreate;

@Service
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

        category.setId(categoryId);
        category.setCategoryName(categoryName);
        category.setDescription(categoryDescription);

        return category;
    }


}
