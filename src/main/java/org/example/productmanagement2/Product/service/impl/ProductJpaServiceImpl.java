package org.example.productmanagement2.Product.service.impl;

import jakarta.transaction.Transactional;
import org.example.productmanagement2.Product.model.Product;
import org.example.productmanagement2.Product.repository.ProductRepository;
import org.example.productmanagement2.Product.service.AuditableProductDtoService;
import org.example.productmanagement2.Product.service.dto.ProductDtoGet;
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
public class ProductJpaServiceImpl extends AuditableDtoJpaServiceImpl<ProductDtoGet, Product, Long> implements AuditableProductDtoService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public AuditableRepository<Product, Long> getRepository() {
        return this.productRepository;
    }

    @Override
    public ProductDtoGet convert(Product product) {
        if (product != null) {
            ProductDtoGet dto = new ProductDtoGet();
            dto.setId(product.getId());
            dto.setCategoryId(product.getCategoryId());
            dto.setPrice(product.getPrice());
            dto.setProductName(product.getProductName());

            return dto;
        }

        return null;
    }

    public ProductJpaServiceImpl() {
        super();
    }

    @Override
    protected Product createEntry(BaseDtoCreate<Product, Long> entity, Long callerId) throws APIException {
        return super.createEntry(entity, callerId);
    }

    @Override
    public Long create(BaseDtoCreate<Product, Long> entity, Long callerId) throws APIException {
        return super.create(entity, callerId);
    }

    @Override
    public ProductDtoGet createAndGet(BaseDtoCreate<Product, Long> entity, Long callerId) throws APIException {
        return super.createAndGet(entity, callerId);
    }

    @Override
    protected List<Product> createEntries(Collection<? extends BaseDtoCreate<Product, Long>> entities, Long callerId) throws APIException {
        return super.createEntries(entities, callerId);
    }

    @Override
    public List<Long> create(Collection<? extends BaseDtoCreate<Product, Long>> entities, Long callerId) throws APIException {
        return super.create(entities, callerId);
    }

    @Override
    public List<ProductDtoGet> createAndGet(Collection<? extends BaseDtoCreate<Product, Long>> entities, Long callerId) throws APIException {
        return super.createAndGet(entities, callerId);
    }

    @Override
    protected Product updateEntry(DtoUpdate<Product, Long> entity, Long callerId) throws APIException {
        return super.updateEntry(entity, callerId);
    }

    @Override
    public Long update(DtoUpdate<Product, Long> entity, Long callerId) throws APIException {
        return super.update(entity, callerId);
    }

    @Override
    public ProductDtoGet updateAndGet(DtoUpdate<Product, Long> entity, Long callerId) throws APIException {
        return super.updateAndGet(entity, callerId);
    }

    @Override
    public void deleteByID(Long id, Long callerId) throws APIException {
        super.deleteByID(id, callerId);
    }

    @Override
    public ProductDtoGet deleteAndGet(Long id, Long callerId) throws APIException {
        return super.deleteAndGet(id, callerId);
    }

    @Override
    public void fetchLazyInformation(ProductDtoGet productDtoGet, Product object) {
        super.fetchLazyInformation(productDtoGet, object);
    }

    @Override
    protected Product validateAndCreateEntry(BaseDtoCreate<Product, Long> entity) throws APIException {
        return super.validateAndCreateEntry(entity);
    }

    @Override
    protected Product validateAndUpdateEntry(DtoUpdate<Product, Long> entity, Product current) throws APIException {
        return super.validateAndUpdateEntry(entity, current);
    }
}
