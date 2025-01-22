package org.example.productmanagement2.Modules.Category.service.dto;

import org.example.productmanagement2.Modules.Category.model.Category;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.service.dto.SerialIDDtoCreate;

@Service
public class CategoryDtoCreate extends SerialIDDtoCreate<Category> {

    private String categoryName;
    private String categoryDescription;

    CategoryDtoCreate() {}

    CategoryDtoCreate(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    @Override
    public Category toEntry() {
        Category category = new Category();

        category.setId(this.getId());
        category.setCategoryName(categoryName);
        category.setDescription(categoryDescription);

        return category;
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
