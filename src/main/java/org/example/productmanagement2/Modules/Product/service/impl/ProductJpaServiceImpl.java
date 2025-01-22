package org.example.productmanagement2.Modules.Product.service.impl;

import jakarta.transaction.Transactional;
import org.example.productmanagement2.Modules.Product.model.Product;
import org.example.productmanagement2.Modules.Product.repository.ProductRepository;
import org.example.productmanagement2.Modules.Product.service.AuditableProductDtoService;
import org.example.productmanagement2.Modules.Product.service.dto.ProductDtoGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.saolasoft.base.persistence.repository.AuditableRepository;
import vn.saolasoft.base.service.impl.AuditableDtoJpaServiceImpl;
import java.util.HashSet;
import java.util.Set;

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
    public Set<String> getSortableColumns() {
        Set<String> sortableColumns = new HashSet<String>();
        sortableColumns.add("id");
        sortableColumns.add("categoryId");
        sortableColumns.add("price");
        sortableColumns.add("productName");

        return sortableColumns;
    }
}
