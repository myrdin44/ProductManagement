package org.example.productmanagement2.category.service.impl;

import org.example.productmanagement2.category.model.Category;
import org.example.productmanagement2.category.repository.CategoryRepository;
import org.example.productmanagement2.category.service.CategoryDtoService;
import org.example.productmanagement2.category.service.dto.CategoryDtoGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.exception.APIException;
import vn.saolasoft.base.persistence.repository.AuditableRepository;
import vn.saolasoft.base.service.dto.BaseDtoCreate;
import vn.saolasoft.base.service.dto.DtoUpdate;
import vn.saolasoft.base.service.impl.AuditableDtoJpaServiceImpl;

import java.util.Collection;
import java.util.List;

@Service
public class CategoryJpaServiceImpl extends AuditableDtoJpaServiceImpl<CategoryDtoGet, Category, String> implements CategoryDtoService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDtoGet convert(Category category) {
        if (category != null) {
            CategoryDtoGet dto = new CategoryDtoGet();
            dto.setCategoryId(category.getId());
            dto.setCategoryName(category.getCategoryName());
            dto.setCategoryDescription(category.getDescription());

            return dto;
        }

        return null;
    }

    @Override
    public CategoryDtoGet convertAndFetchLazyInformation(Category category) {
        if (category != null) {
            CategoryDtoGet dto = new CategoryDtoGet();
            dto.setCategoryId(category.getId());
            dto.setCategoryName(category.getCategoryName());
            dto.setCategoryDescription(category.getDescription());

            return dto;
        }

        return null;
    }

    @Override
    public boolean existsById(String s) {
        return categoryRepository.existsById(s);
    }



    @Override
    public CategoryDtoGet getById(String uuid) throws APIException {
        if (categoryRepository.existsById(uuid)) {
            Category category = categoryRepository.findById(uuid).orElse(null);
            return convertAndFetchLazyInformation(category);
        }

        return null;
    }


    @Override
    public void deleteByID(String uuid) throws APIException {
        if (!categoryRepository.existsById(uuid)) {
            throw new APIException("Category not found");
        }

        categoryRepository.deleteById(uuid);
    }

    @Override
    public CategoryDtoGet deleteAndGet(String uuid) throws APIException {
        if (!categoryRepository.existsById(uuid)) {
            throw new APIException("Category not found");
        }

        Category category = categoryRepository.findById(uuid).orElse(null);
        categoryRepository.deleteById(uuid);
        return convertAndFetchLazyInformation(category);
    }

    public CategoryJpaServiceImpl() {
        super();
    }

    @Override
    public AuditableRepository<Category, String> getRepository() {
        return this.categoryRepository;
    }

    @Override
    protected Category createEntry(BaseDtoCreate<Category, String> entity, Long callerId) throws APIException {
        return super.createEntry(entity, callerId);
    }

    @Override
    public String create(BaseDtoCreate<Category, String> entity, Long callerId) throws APIException {
        return super.create(entity, callerId);
    }

    @Override
    public CategoryDtoGet createAndGet(BaseDtoCreate<Category, String> entity, Long callerId) throws APIException {
        return super.createAndGet(entity, callerId);
    }

    @Override
    protected List<Category> createEntries(Collection<? extends BaseDtoCreate<Category, String>> entities, Long callerId) throws APIException {
        return super.createEntries(entities, callerId);
    }

    @Override
    public List<String> create(Collection<? extends BaseDtoCreate<Category, String>> entities, Long callerId) throws APIException {
        return super.create(entities, callerId);
    }

    @Override
    public List<CategoryDtoGet> createAndGet(Collection<? extends BaseDtoCreate<Category, String>> entities, Long callerId) throws APIException {
        return super.createAndGet(entities, callerId);
    }

    @Override
    protected Category updateEntry(DtoUpdate<Category, String> entity, Long callerId) throws APIException {
        return super.updateEntry(entity, callerId);
    }

    @Override
    public String update(DtoUpdate<Category, String> entity, Long callerId) throws APIException {
        return super.update(entity, callerId);
    }

    @Override
    public CategoryDtoGet updateAndGet(DtoUpdate<Category, String> entity, Long callerId) throws APIException {
        return super.updateAndGet(entity, callerId);
    }

    @Override
    public void deleteByID(String s, Long callerId) throws APIException {
        super.deleteByID(s, callerId);
    }

    @Override
    public CategoryDtoGet deleteAndGet(String s, Long callerId) throws APIException {
        return super.deleteAndGet(s, callerId);
    }
}
