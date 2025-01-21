package org.example.productmanagement2.product.repository;

import org.example.productmanagement2.product.model.Product;
import org.springframework.stereotype.Repository;
import vn.saolasoft.base.persistence.repository.AuditableRepository;

@Repository
public interface ProductRepository extends AuditableRepository<Product, Long> {
}
