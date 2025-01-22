package org.example.productmanagement2.Category.service.impl;

import jakarta.transaction.Transactional;
import org.example.productmanagement2.Category.model.Category;
import org.example.productmanagement2.Category.repository.CategoryRepository;
import org.example.productmanagement2.Category.service.CategoryDtoService;
import org.example.productmanagement2.Category.service.dto.CategoryDtoGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.exception.APIException;
import vn.saolasoft.base.persistence.repository.AuditableRepository;
import vn.saolasoft.base.service.dto.BaseDtoCreate;
import vn.saolasoft.base.service.dto.DtoUpdate;
import vn.saolasoft.base.service.impl.AuditableDtoJpaServiceImpl;

import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class CategoryJpaServiceImpl extends AuditableDtoJpaServiceImpl<CategoryDtoGet, Category, Long> implements CategoryDtoService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDtoGet convert(Category category) {
        if (category != null) {
            CategoryDtoGet dto = new CategoryDtoGet();
            dto.setId(category.getId());
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
            dto.setId(category.getId());
            dto.setCategoryName(category.getCategoryName());
            dto.setCategoryDescription(category.getDescription());

            return dto;
        }

        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return categoryRepository.existsById(id);
    }



    @Override
    public CategoryDtoGet getById(Long uuid) throws APIException {
        if (categoryRepository.existsById(uuid)) {
            Category category = categoryRepository.findById(uuid).orElse(null);
            return convertAndFetchLazyInformation(category);
        }

        return null;
    }


    @Override
    public void deleteByID(Long uuid) throws APIException {
        if (!categoryRepository.existsById(uuid)) {
            throw new APIException("Category not found");
        }

        categoryRepository.deleteById(uuid);
    }

    @Override
    public CategoryDtoGet deleteAndGet(Long uuid) throws APIException {
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
    public AuditableRepository<Category, Long> getRepository() {
        return this.categoryRepository;
    }

    @Override
    protected Category createEntry(BaseDtoCreate<Category, Long> entity, Long callerId) throws APIException {
        return super.createEntry(entity, callerId);
    }

    @Override
    public Long create(BaseDtoCreate<Category, Long> entity, Long callerId) throws APIException {
        return super.create(entity, callerId);
    }

    @Override
    public CategoryDtoGet createAndGet(BaseDtoCreate<Category, Long> entity, Long callerId) throws APIException {
        return super.createAndGet(entity, callerId);
    }

    @Override
    protected List<Category> createEntries(Collection<? extends BaseDtoCreate<Category, Long>> entities, Long callerId) throws APIException {
        return super.createEntries(entities, callerId);
    }

    @Override
    public List<Long> create(Collection<? extends BaseDtoCreate<Category, Long>> entities, Long callerId) throws APIException {
        return super.create(entities, callerId);
    }

    @Override
    public List<CategoryDtoGet> createAndGet(Collection<? extends BaseDtoCreate<Category, Long>> entities, Long callerId) throws APIException {
        return super.createAndGet(entities, callerId);
    }

    @Override
    protected Category updateEntry(DtoUpdate<Category, Long> entity, Long callerId) throws APIException {
        return super.updateEntry(entity, callerId);
    }

    @Override
    public Long update(DtoUpdate<Category, Long> entity, Long callerId) throws APIException {
        return super.update(entity, callerId);
    }

    @Override
    public CategoryDtoGet updateAndGet(DtoUpdate<Category, Long> entity, Long callerId) throws APIException {
        return super.updateAndGet(entity, callerId);
    }

    @Override
    public void deleteByID(Long id, Long callerId) throws APIException {
        super.deleteByID(id, callerId);
    }

    @Override
    public CategoryDtoGet deleteAndGet(Long id, Long callerId) throws APIException {
        return super.deleteAndGet(id, callerId);
    }
}
