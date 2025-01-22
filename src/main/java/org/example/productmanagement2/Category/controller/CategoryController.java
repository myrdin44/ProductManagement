package org.example.productmanagement2.Category.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.PostConstruct;
import org.example.productmanagement2.Category.model.Category;
import org.example.productmanagement2.Category.query.SearchQuery;
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
import vn.saolasoft.base.service.filter.PaginationInfo;
import vn.saolasoft.base.service.filter.SortInfo;
import java.util.List;

@RestController
@RequestMapping("/stock")
@Api(tags = "Category apis", value = "Controller handle crud operation")
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
    @ApiOperation(tags = "list", value = "listed completely!")
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> getListCategory(@RequestParam("firstRow") int firstRow,
                                                                                 @RequestParam("maxResult") int maxResult,
                                                                                 @RequestParam("orderColumn") String orderColumn,
                                                                                 @RequestParam("ascending") boolean ascending) {
        PaginationInfo paginationInfo = new PaginationInfo(firstRow, maxResult, new SortInfo(orderColumn, ascending));
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

    @PostMapping("/search")
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> search(@RequestBody SearchQuery searchQuery) {

        PaginationInfo paginationInfo = new PaginationInfo();
        return auditableDtoAPIMethod.search(searchQuery, paginationInfo);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<Long>> deleteCategory(@RequestParam("id") Long id) {
        return auditableDtoAPIMethod.delete(id, 1L);
    }

    @GetMapping("/get-one")
    public ResponseEntity<APIResponse<CategoryDtoGet>> getCategory(@RequestParam("id") Long id) {
        return auditableDtoAPIMethod.getById(id);
    }
}
