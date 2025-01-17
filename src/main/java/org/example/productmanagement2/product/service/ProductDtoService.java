package org.example.productmanagement2.product.service;

import org.example.productmanagement2.product.model.Product;
import org.example.productmanagement2.product.service.dto.ProductDtoGet;
import vn.saolasoft.base.exception.APIException;
import vn.saolasoft.base.service.AuditableDtoService;
import vn.saolasoft.base.service.dto.BaseDtoCreate;
import vn.saolasoft.base.service.dto.DtoUpdate;

import java.util.Collection;
import java.util.List;

public interface ProductDtoService extends AuditableDtoService<ProductDtoGet, Product, String> {
    @Override
    ProductDtoGet createAndGet(BaseDtoCreate<Product, String> baseDtoCreate, Long aLong) throws APIException;

    @Override
    String create(BaseDtoCreate<Product, String> baseDtoCreate, Long aLong) throws APIException;

    @Override
    List<ProductDtoGet> createAndGet(Collection<? extends BaseDtoCreate<Product, String>> collection, Long aLong) throws APIException;

    @Override
    List<String> create(Collection<? extends BaseDtoCreate<Product, String>> collection, Long aLong) throws APIException;

    @Override
    ProductDtoGet updateAndGet(DtoUpdate<Product, String> dtoUpdate, Long aLong) throws APIException;

    @Override
    String update(DtoUpdate<Product, String> dtoUpdate, Long aLong) throws APIException;

    @Override
    void deleteByID(String s, Long aLong) throws APIException;

    @Override
    ProductDtoGet deleteAndGet(String s, Long aLong) throws APIException;
}
