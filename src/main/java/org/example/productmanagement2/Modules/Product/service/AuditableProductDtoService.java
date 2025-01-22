package org.example.productmanagement2.Modules.Product.service;

import org.example.productmanagement2.Modules.Product.model.Product;
import org.example.productmanagement2.Modules.Product.service.dto.ProductDtoGet;
import vn.saolasoft.base.exception.APIException;
import vn.saolasoft.base.service.AuditableDtoService;
import vn.saolasoft.base.service.dto.BaseDtoCreate;
import vn.saolasoft.base.service.dto.DtoUpdate;

import java.util.Collection;
import java.util.List;

public interface AuditableProductDtoService extends AuditableDtoService<ProductDtoGet, Product, Long> {
    @Override
    ProductDtoGet createAndGet(BaseDtoCreate<Product, Long> baseDtoCreate, Long aLong) throws APIException;

    @Override
    Long create(BaseDtoCreate<Product, Long> baseDtoCreate, Long aLong) throws APIException;

    @Override
    List<ProductDtoGet> createAndGet(Collection<? extends BaseDtoCreate<Product, Long>> collection, Long aLong) throws APIException;

    @Override
    List<Long> create(Collection<? extends BaseDtoCreate<Product, Long>> collection, Long aLong) throws APIException;

    @Override
    ProductDtoGet updateAndGet(DtoUpdate<Product, Long> dtoUpdate, Long aLong) throws APIException;

    @Override
    Long update(DtoUpdate<Product, Long> dtoUpdate, Long aLong) throws APIException;

    @Override
    void deleteByID(Long id, Long aLong) throws APIException;

    @Override
    ProductDtoGet deleteAndGet(Long id, Long aLong) throws APIException;
}
