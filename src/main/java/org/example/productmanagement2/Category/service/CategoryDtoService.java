package org.example.productmanagement2.Category.service;

import org.example.productmanagement2.Category.model.Category;
import org.example.productmanagement2.Category.service.dto.CategoryDtoGet;
import vn.saolasoft.base.exception.APIException;
import vn.saolasoft.base.service.AuditableDtoService;

import vn.saolasoft.base.service.dto.BaseDtoCreate;
import vn.saolasoft.base.service.dto.DtoUpdate;

import java.util.Collection;
import java.util.List;

public interface CategoryDtoService extends AuditableDtoService<CategoryDtoGet, Category, Long> {

    @Override
    CategoryDtoGet createAndGet(BaseDtoCreate<Category, Long> baseDtoCreate, Long aLong) throws APIException;

    @Override
    Long create(BaseDtoCreate<Category, Long> baseDtoCreate, Long aLong) throws APIException;

    @Override
    List<CategoryDtoGet> createAndGet(Collection<? extends BaseDtoCreate<Category, Long>> collection, Long aLong) throws APIException;

    @Override
    List<Long> create(Collection<? extends BaseDtoCreate<Category, Long>> collection, Long aLong) throws APIException;

    @Override
    CategoryDtoGet updateAndGet(DtoUpdate<Category, Long> dtoUpdate, Long aLong) throws APIException;

    @Override
    Long update(DtoUpdate<Category, Long> dtoUpdate, Long aLong) throws APIException;

    @Override
    void deleteByID(Long id, Long aLong) throws APIException;

    @Override
    CategoryDtoGet deleteAndGet(Long id, Long aLong) throws APIException;
}
