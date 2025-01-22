package org.example.productmanagement2.Modules.Category.service;

import org.example.productmanagement2.Modules.Category.model.Category;
import org.example.productmanagement2.Modules.Category.service.dto.CategoryDtoGet;
import vn.saolasoft.base.service.AuditableDtoService;


public interface CategoryDtoService extends AuditableDtoService<CategoryDtoGet, Category, Long> {

}
