package org.example.productmanagement2.Modules.Product.service;

import org.example.productmanagement2.Modules.Product.model.Product;
import org.example.productmanagement2.Modules.Product.service.dto.ProductDtoGet;
import vn.saolasoft.base.service.AuditableDtoService;

public interface AuditableProductDtoService extends AuditableDtoService<ProductDtoGet, Product, Long> {

}
