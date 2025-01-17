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
public class CategoryController extends AuditableDtoAPIMethod<CategoryDtoGet,Category, String> {
    @Autowired
    private CategoryJpaServiceImpl categoryService;

    public CategoryController(@Qualifier("categoryJpaServiceImpl") AuditableDtoService service) {
        super(service);
    }

    @Override
    public AuditableDtoService<CategoryDtoGet, Category, String> getService() {
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
    public ResponseEntity<APIResponse<CategoryDtoGet>> getById(@RequestParam("uuid") String uuid) {
        return super.getById(uuid);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<APIResponse<String>> create(@RequestBody BaseDtoCreate<Category, String> object,@RequestParam("creatorId") Long callerId) {
        return super.create(object, callerId);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<APIResponse<String>> update(DtoUpdate<Category, String> object, Long callerId) {
        return super.update(object, callerId);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> delete(String s, Long callerId) {
        return super.delete(s, callerId);
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<APIListResponse<List<CategoryDtoGet>>> search(BaseFilter<Category, String> filter, PaginationInfo pageInfo) {
        return super.search(filter, pageInfo);
    }
}
