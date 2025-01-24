package org.example.productmanagement2.Modules.Category.controller;

import jakarta.annotation.PostConstruct;
import org.example.productmanagement2.Modules.Category.model.Category;
import org.example.productmanagement2.Modules.Category.service.dto.CategoryDtoCreate;
import org.example.productmanagement2.Modules.Category.service.dto.CategoryDtoGet;
import org.example.productmanagement2.Modules.Category.service.dto.CategoryDtoUpdate;
import org.example.productmanagement2.Modules.Category.service.dto.query.SearchQuery;
import org.example.productmanagement2.Modules.Category.service.impl.CategoryJpaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.saolasoft.base.api.method.AuditableDtoAPIMethod;
import vn.saolasoft.base.api.response.APIListResponse;
import vn.saolasoft.base.api.response.APIResponse;
import vn.saolasoft.base.service.filter.PaginationInfo;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryJpaServiceImpl categoryJpaService;

    private AuditableDtoAPIMethod<CategoryDtoGet, Category, Long> auditableDtoAPIMethod = new AuditableDtoAPIMethod<>(categoryJpaService);

    @PostConstruct
    public void init() {
        this.auditableDtoAPIMethod = new AuditableDtoAPIMethod<>(categoryJpaService);
    }

    @GetMapping
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> getListCategory(@RequestParam(value = "firstRow", defaultValue = "0") int firstRow,
                                                                                 @RequestParam(value = "maxResult", defaultValue = "9") int maxResult,
                                                                                 @RequestParam(value = "orderColumn", defaultValue = "id") String orderColumn) {

        PaginationInfo paginationInfo = new PaginationInfo(firstRow, maxResult, orderColumn);
        return auditableDtoAPIMethod.getList(paginationInfo);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Long>> createCategory(@RequestBody CategoryDtoCreate categoryDtoCreate) {
        logger.info(categoryDtoCreate.toString());
        return auditableDtoAPIMethod.create(categoryDtoCreate, 1L);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Long>> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDtoUpdate categoryDtoUpdate) {
        categoryDtoUpdate.setId(id);
        return auditableDtoAPIMethod.update(categoryDtoUpdate, 1L);
    }

    @PostMapping("/search")
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> search(@RequestBody SearchQuery searchQuery) {

        PaginationInfo paginationInfo = new PaginationInfo();
        return auditableDtoAPIMethod.search(searchQuery, paginationInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Long>> deleteCategory(@PathVariable("id") Long id) {
        return auditableDtoAPIMethod.delete(id, 1L);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<CategoryDtoGet>> getCategory(@PathVariable("id") Long id) {
        return auditableDtoAPIMethod.getById(id);
    }
}