package org.example.productmanagement2.Modules.Product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.productmanagement2.Modules.Product.model.Product;
import org.example.productmanagement2.Modules.Product.service.dto.query.SearchQuery;
import org.example.productmanagement2.Modules.Product.service.dto.ProductDtoCreate;
import org.example.productmanagement2.Modules.Product.service.dto.ProductDtoGet;
import org.example.productmanagement2.Modules.Product.service.dto.ProductDtoUpdate;
import org.example.productmanagement2.Modules.Product.service.impl.ProductJpaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.saolasoft.base.api.method.AuditableDtoAPIMethod;
import vn.saolasoft.base.api.response.APIListResponse;
import vn.saolasoft.base.api.response.APIResponse;
import vn.saolasoft.base.service.filter.PaginationInfo;
import java.util.List;

@RestController
@RequestMapping("/products")
@Api
public class ProductController{
    private static final Log log = LogFactory.getLog(ProductController.class);
    @Autowired
    private ProductJpaServiceImpl productService;

    private AuditableDtoAPIMethod<ProductDtoGet, Product, String> auditableDtoAPIMethod = new AuditableDtoAPIMethod<>(productService);

    @PostConstruct
    public void init() {
        this.auditableDtoAPIMethod = new AuditableDtoAPIMethod<>(productService);
    }

    @GetMapping
    @ApiOperation(value = "List Products")
    public ResponseEntity<APIListResponse<List<ProductDtoGet>>> getListProducts(@RequestParam("firstRow") int firstRow,
                                                                                @RequestParam("maxResult") int maxResult,
                                                                                @RequestParam("orderColumn") String orderColumn) {
        PaginationInfo paginationInfo = new PaginationInfo(firstRow, maxResult, orderColumn);
        return auditableDtoAPIMethod.getList(paginationInfo);
    }

    @PostMapping
    public ResponseEntity<APIResponse<String>> createProduct(@RequestBody ProductDtoCreate productDtoCreate){
        log.debug("Received DTO {}" + productDtoCreate);
        return auditableDtoAPIMethod.create(productDtoCreate, 1L);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<APIResponse<ProductDtoGet>> getProductById(@PathVariable String uuid){
        return auditableDtoAPIMethod.getById(uuid);
    }

    @PostMapping("/search")
    public ResponseEntity<APIListResponse<List<ProductDtoGet>>> search(@RequestBody SearchQuery searchQuery){
        PaginationInfo paginationInfo = new PaginationInfo();
        return auditableDtoAPIMethod.search(searchQuery, paginationInfo);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<APIResponse<String>> updateProduct(@PathVariable String uuid, @RequestBody ProductDtoUpdate productDtoUpdate){
        productDtoUpdate.setId(uuid);
        return auditableDtoAPIMethod.update(productDtoUpdate, 1L);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<APIResponse<String>> deleteProduct(@PathVariable("uuid") String uuid){
        return auditableDtoAPIMethod.delete(uuid, 1L);
    }

}
