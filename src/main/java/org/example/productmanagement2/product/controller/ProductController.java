package org.example.productmanagement2.product.controller;

import org.example.productmanagement2.product.model.Product;
import org.example.productmanagement2.product.service.dto.ProductDtoGet;
import org.example.productmanagement2.product.service.impl.ProductJpaServiceImpl;
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
@RequestMapping("/details")
public class ProductController extends AuditableDtoAPIMethod<ProductDtoGet, Product, String> {
    @Autowired
    private ProductJpaServiceImpl productService;

    public ProductController(@Qualifier("productJpaServiceImpl") AuditableDtoService service) {
        super(service);
    }

    @Override
    public AuditableDtoService<ProductDtoGet, Product, String> getService() {
        return super.getService();
    }

    @Override
    @GetMapping("/logger")
    public Logger getLogger() {
        return super.getLogger();
    }

    @Override
    @GetMapping("/list")
    public ResponseEntity<APIListResponse<List<ProductDtoGet>>> getList(@RequestBody PaginationInfo pageInfo) {
        return super.getList(pageInfo);
    }

    @Override
    @GetMapping("/get-one")
    public ResponseEntity<APIResponse<ProductDtoGet>> getById(@RequestParam("sku") String sku) {
        return super.getById(sku);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<APIResponse<String>> create(@RequestBody BaseDtoCreate<Product, String> product, Long callerId) {
        return super.create(product, callerId);
    }

    @Override
    @PostMapping("/update")
    public ResponseEntity<APIResponse<String>> update(DtoUpdate<Product, String> object, Long callerId) {
        return super.update(object, callerId);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> delete(@RequestParam("sku") String sku, Long callerId) {
        return super.delete(sku, callerId);
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<APIListResponse<List<ProductDtoGet>>> search(BaseFilter<Product, String> filter, PaginationInfo pageInfo) {
        return super.search(filter, pageInfo);
    }
}
