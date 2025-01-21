package org.example.productmanagement2.product.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.productmanagement2.product.model.Product;
import org.example.productmanagement2.product.request.SearchRequest;
import org.example.productmanagement2.product.service.dto.ProductDtoCreate;
import org.example.productmanagement2.product.service.dto.ProductDtoGet;
import org.example.productmanagement2.product.service.dto.ProductDtoUpdate;
import org.example.productmanagement2.product.service.impl.ProductJpaServiceImpl;
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
@RequestMapping("/pd")
@Api
public class ProductController{
    private static final Log log = LogFactory.getLog(ProductController.class);
    @Autowired
    private ProductJpaServiceImpl productService;

    private AuditableDtoAPIMethod<ProductDtoGet, Product, Long> auditableDtoAPIMethod = new AuditableDtoAPIMethod<ProductDtoGet, Product, Long>(productService);

    @PostConstruct
    public void init() {
        this.auditableDtoAPIMethod = new AuditableDtoAPIMethod<>(productService);
    }

    @GetMapping("/list")
    @ApiOperation(value = "List Products")
    public ResponseEntity<APIListResponse<List<ProductDtoGet>>> getListProducts(@RequestBody PaginationInfo paginationInfo){
        return auditableDtoAPIMethod.getList(paginationInfo);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse<Long>> createProduct(@RequestBody ProductDtoCreate productDtoCreate){
        log.debug("Received DTO {}" + productDtoCreate);
        return auditableDtoAPIMethod.create(productDtoCreate, 1L);
    }

    @GetMapping("/get-one")
    public ResponseEntity<APIResponse<ProductDtoGet>> getProductById(@RequestParam("id") Long productId){
        return auditableDtoAPIMethod.getById(productId);
    }

    @GetMapping("/search")
    public ResponseEntity<APIListResponse<List<ProductDtoGet>>> search(@RequestBody SearchRequest searchRequest){
        BaseFilter<Product, Long> baseFilter = searchRequest.getBaseFilter();

        PaginationInfo paginationInfo = searchRequest.getPaginationInfo();

        return auditableDtoAPIMethod.search(baseFilter, paginationInfo);
    }

    @PutMapping("/update")
    public ResponseEntity<APIResponse<Long>> updateProduct(@RequestBody ProductDtoUpdate productDtoUpdate){
        return auditableDtoAPIMethod.update(productDtoUpdate, 1L);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<Long>> deleteProduct(@RequestParam("id") Long productId){
        return auditableDtoAPIMethod.delete(productId, 1L);
    }
}
