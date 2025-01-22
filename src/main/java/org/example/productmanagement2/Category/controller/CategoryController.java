package org.example.productmanagement2.Category.controller;

import jakarta.annotation.PostConstruct;
import org.example.productmanagement2.Category.model.Category;
import org.example.productmanagement2.Category.request.SearchRequest;
import org.example.productmanagement2.Category.service.dto.CategoryDtoCreate;
import org.example.productmanagement2.Category.service.dto.CategoryDtoGet;
import org.example.productmanagement2.Category.service.dto.CategoryDtoUpdate;
import org.example.productmanagement2.Category.service.impl.CategoryJpaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.saolasoft.base.api.method.AuditableDtoAPIMethod;
import vn.saolasoft.base.api.response.APIListResponse;
import vn.saolasoft.base.api.response.APIResponse;
import vn.saolasoft.base.service.filter.BaseFilter;
import vn.saolasoft.base.service.filter.PaginationInfo;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryJpaServiceImpl categoryJpaService;

    private AuditableDtoAPIMethod<CategoryDtoGet, Category, Long> auditableDtoAPIMethod = new AuditableDtoAPIMethod<>(categoryJpaService);

    @PostConstruct
    public void init() {
        this.auditableDtoAPIMethod = new AuditableDtoAPIMethod<>(categoryJpaService);
    }

    @GetMapping("/list")
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> getListCategory(@RequestBody PaginationInfo paginationInfo) {
        return auditableDtoAPIMethod.getList(paginationInfo);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse<Long>> createCategory(@RequestBody CategoryDtoCreate categoryDtoCreate) {
        logger.info(categoryDtoCreate.toString());
        return auditableDtoAPIMethod.create(categoryDtoCreate, 1L);
    }

    @PutMapping("/update")
    public ResponseEntity<APIResponse<Long>> updateCategory(@RequestBody CategoryDtoUpdate categoryDtoUpdate) {
        logger.info(categoryDtoUpdate.toString());
        return auditableDtoAPIMethod.update(categoryDtoUpdate, 1L);
    }

    @GetMapping("/search")
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> search(@RequestBody SearchRequest searchRequest) {
        BaseFilter<Category, Long> baseFilter = searchRequest.getBaseFilter();

        PaginationInfo paginationInfo = searchRequest.getPaginationInfo();

        return auditableDtoAPIMethod.search(baseFilter, paginationInfo);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<Long>> deleteCategory(@RequestParam Long id) {
        return auditableDtoAPIMethod.delete(id, 1L);
    }

    @GetMapping("/get-one")
    public ResponseEntity<APIResponse<CategoryDtoGet>> getCategory(@RequestParam Long id) {
        return auditableDtoAPIMethod.getById(id);
    }
}
