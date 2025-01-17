package org.example.productmanagement2.category.service;

import org.example.productmanagement2.category.model.Category;
import org.example.productmanagement2.category.service.dto.CategoryDtoGet;
import vn.saolasoft.base.exception.APIException;
import vn.saolasoft.base.service.AuditableDtoService;

import vn.saolasoft.base.service.dto.BaseDtoCreate;
import vn.saolasoft.base.service.dto.DtoUpdate;

import java.util.Collection;
import java.util.List;

public interface CategoryDtoService extends AuditableDtoService<CategoryDtoGet, Category, String> {

    @Override
    CategoryDtoGet createAndGet(BaseDtoCreate<Category, String> baseDtoCreate, Long aLong) throws APIException;

    @Override
    String create(BaseDtoCreate<Category, String> baseDtoCreate, Long aLong) throws APIException;

    @Override
    List<CategoryDtoGet> createAndGet(Collection<? extends BaseDtoCreate<Category, String>> collection, Long aLong) throws APIException;

    @Override
    List<String> create(Collection<? extends BaseDtoCreate<Category, String>> collection, Long aLong) throws APIException;

    @Override
    CategoryDtoGet updateAndGet(DtoUpdate<Category, String> dtoUpdate, Long aLong) throws APIException;

    @Override
    String update(DtoUpdate<Category, String> dtoUpdate, Long aLong) throws APIException;

    @Override
    void deleteByID(String s, Long aLong) throws APIException;

    @Override
    CategoryDtoGet deleteAndGet(String s, Long aLong) throws APIException;
}
