package org.example.productmanagement2.category.controller;

import org.example.productmanagement2.category.model.Category;
import org.example.productmanagement2.category.service.CategoryService;
import org.example.productmanagement2.category.service.filter.CategoryFilter;
import org.example.productmanagement2.category.service.filter.CategoryIntegration;
import org.example.productmanagement2.category.service.filter.CategoryPaging;
import org.example.productmanagement2.category.service.filter.CategorySort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getFilteredCategories(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String description,
                                                @RequestParam(required = false, defaultValue = "0") int page,
                                                @RequestParam(required = false, defaultValue = "10") int size,
                                                @RequestParam(required = false, defaultValue = "categoryName") String orderColumn,
                                                @RequestParam(required = false, defaultValue = "asc") boolean ascending){

        CategoryFilter filter = new CategoryFilter();
        filter.setCategoryName(name);
        filter.setCategoryDescription(description);

        CategorySort sort = new CategorySort(orderColumn, ascending);


        CategoryPaging paging = new CategoryPaging();
        paging.setPage(page);
        paging.setSize(size);

        CategoryIntegration integrationCriteria = new CategoryIntegration(filter, sort, paging);

        return categoryService.getFilteredCategories(integrationCriteria);
    }
}
