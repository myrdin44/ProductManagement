package org.example.productmanagement2.product.service.impl;

import org.example.productmanagement2.product.model.Product;
import org.example.productmanagement2.product.repository.ProductRepository;
import org.example.productmanagement2.product.service.ProductDtoService;
import org.example.productmanagement2.product.service.dto.ProductDtoGet;
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
public class ProductJpaServiceImpl extends AuditableDtoJpaServiceImpl<ProductDtoGet, Product, String> implements ProductDtoService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public AuditableRepository<Product, String> getRepository() {
        return this.productRepository;
    }

    @Override
    public ProductDtoGet convert(Product product) {
        if (product != null) {
            ProductDtoGet dto = new ProductDtoGet();
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
    protected Product createEntry(BaseDtoCreate<Product, String> entity, Long callerId) throws APIException {
        return super.createEntry(entity, callerId);
    }

    @Override
    public String create(BaseDtoCreate<Product, String> entity, Long callerId) throws APIException {
        return super.create(entity, callerId);
    }

    @Override
    public ProductDtoGet createAndGet(BaseDtoCreate<Product, String> entity, Long callerId) throws APIException {
        return super.createAndGet(entity, callerId);
    }

    @Override
    protected List<Product> createEntries(Collection<? extends BaseDtoCreate<Product, String>> entities, Long callerId) throws APIException {
        return super.createEntries(entities, callerId);
    }

    @Override
    public List<String> create(Collection<? extends BaseDtoCreate<Product, String>> entities, Long callerId) throws APIException {
        return super.create(entities, callerId);
    }

    @Override
    public List<ProductDtoGet> createAndGet(Collection<? extends BaseDtoCreate<Product, String>> entities, Long callerId) throws APIException {
        return super.createAndGet(entities, callerId);
    }

    @Override
    protected Product updateEntry(DtoUpdate<Product, String> entity, Long callerId) throws APIException {
        return super.updateEntry(entity, callerId);
    }

    @Override
    public String update(DtoUpdate<Product, String> entity, Long callerId) throws APIException {
        return super.update(entity, callerId);
    }

    @Override
    public ProductDtoGet updateAndGet(DtoUpdate<Product, String> entity, Long callerId) throws APIException {
        return super.updateAndGet(entity, callerId);
    }

    @Override
    public void deleteByID(String s, Long callerId) throws APIException {
        super.deleteByID(s, callerId);
    }

    @Override
    public ProductDtoGet deleteAndGet(String s, Long callerId) throws APIException {
        return super.deleteAndGet(s, callerId);
    }
}
