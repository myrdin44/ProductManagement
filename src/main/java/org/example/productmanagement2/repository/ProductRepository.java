package org.example.productmanagement2.repository;

import org.example.productmanagement2.model.Product;
import vn.saolasoft.base.persistence.repository.AuditableRepository;

public interface ProductRepository extends AuditableRepository<Product, String> {
}
