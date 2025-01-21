package org.example.productmanagement2.category.controller;

import org.example.productmanagement2.category.model.Category;
import org.example.productmanagement2.category.service.dto.CategoryDtoGet;
import org.example.productmanagement2.category.service.impl.CategoryJpaServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.saolasoft.base.api.method.AuditableDtoAPIMethod;
import vn.saolasoft.base.api.response.APIListResponse;
import vn.saolasoft.base.api.response.APIResponse;
import vn.saolasoft.base.service.AuditableDtoService;
import vn.saolasoft.base.service.dto.BaseDtoCreate;
import vn.saolasoft.base.service.dto.DtoUpdate;
import vn.saolasoft.base.service.filter.BaseFilter;
import vn.saolasoft.base.service.filter.PaginationInfo;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class CategoryController extends AuditableDtoAPIMethod<CategoryDtoGet,Category, Long> {
    @Autowired
    private CategoryJpaServiceImpl categoryService;

    public CategoryController(@Qualifier("categoryJpaServiceImpl") AuditableDtoService service) {
        super(service);
    }

    @Override
    public AuditableDtoService<CategoryDtoGet, Category, Long> getService() {
        return super.getService();
    }

    @Override
    @GetMapping("/logger")
    public Logger getLogger() {
        return super.getLogger();
    }

    @Override
    @GetMapping("/list")
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> getList(@RequestBody PaginationInfo pageInfo) {
        return super.getList(pageInfo);
    }

    @Override
    @GetMapping("/get-one")
    public ResponseEntity<APIResponse<CategoryDtoGet>> getById(@RequestParam("uuid") Long uuid) {
        return super.getById(uuid);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<APIResponse<Long>> create(@RequestBody BaseDtoCreate<Category, Long> object,@RequestParam("creatorId") Long callerId) {
        return super.create(object, callerId);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<APIResponse<Long>> update(DtoUpdate<Category, Long> object, Long callerId) {
        return super.update(object, callerId);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<Long>> delete(Long id, Long callerId) {
        return super.delete(id, callerId);
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> search(BaseFilter<Category, Long> filter, PaginationInfo pageInfo) {
        return super.search(filter, pageInfo);
    }
}
