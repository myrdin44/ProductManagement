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
@RequestMapping("/pd")
@Api
public class ProductController{
    private static final Log log = LogFactory.getLog(ProductController.class);
    @Autowired
    private ProductJpaServiceImpl productService;

    private AuditableDtoAPIMethod<ProductDtoGet, Product, String> auditableDtoAPIMethod = new AuditableDtoAPIMethod<ProductDtoGet, Product, String>(productService);

    @PostConstruct
    public void init() {
        this.auditableDtoAPIMethod = new AuditableDtoAPIMethod<>(productService);
    }

    @GetMapping("/list")
    @ApiOperation(value = "List Products")
    public ResponseEntity<APIListResponse<List<ProductDtoGet>>> getListProducts(@RequestParam("firstRow") int firstRow,
                                                                                @RequestParam("maxResult") int maxResult,
                                                                                @RequestParam("orderColumn") String orderColumn) {
        PaginationInfo paginationInfo = new PaginationInfo(firstRow, maxResult, orderColumn);
        return auditableDtoAPIMethod.getList(paginationInfo);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse<String>> createProduct(@RequestBody ProductDtoCreate productDtoCreate){
        log.debug("Received DTO {}" + productDtoCreate);
        return auditableDtoAPIMethod.create(productDtoCreate, 1L);
    }

    @GetMapping("/get-one")
    public ResponseEntity<APIResponse<ProductDtoGet>> getProductById(@RequestParam("id") String productId){
        return auditableDtoAPIMethod.getById(productId);
    }

    @PostMapping("/search")
    public ResponseEntity<APIListResponse<List<ProductDtoGet>>> search(@RequestBody SearchQuery searchQuery){
        PaginationInfo paginationInfo = new PaginationInfo();
        return auditableDtoAPIMethod.search(searchQuery, paginationInfo);
    }

    @PutMapping("/update")
    public ResponseEntity<APIResponse<String>> updateProduct(@RequestBody ProductDtoUpdate productDtoUpdate){
        return auditableDtoAPIMethod.update(productDtoUpdate, 1L);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> deleteProduct(@RequestParam("id") String productId){
        return auditableDtoAPIMethod.delete(productId, 1L);
    }

}
