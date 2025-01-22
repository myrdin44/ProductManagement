package org.example.productmanagement2.Modules.Product.repository;

import org.example.productmanagement2.Modules.Product.model.Product;
import org.springframework.stereotype.Repository;
import vn.saolasoft.base.persistence.repository.AuditableRepository;

@Repository
public interface ProductRepository extends AuditableRepository<Product, Long> {
}
