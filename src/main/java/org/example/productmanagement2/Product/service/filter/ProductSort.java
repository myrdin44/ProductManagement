package org.example.productmanagement2.Product.service.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;
import vn.saolasoft.base.service.filter.SortInfo;

import java.io.Serial;
@Component
public class ProductSort extends SortInfo {
    @Serial
    private static final long serialVersionUID = 1L;

    private String orderColumn;
    private boolean ascending;

    public ProductSort() {
        super();
    }

    public ProductSort(String orderColumn, boolean ascending) {
        super();
        this.orderColumn = orderColumn;
        this.ascending = ascending;
    }

    @Override
    public String getOrderColumn() {
        return orderColumn;
    }

    @Override
    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public void applySorting(CriteriaQuery<?> query, Root<?> root, CriteriaBuilder builder) {
        if (orderColumn != null && !orderColumn.isEmpty()) {
            if (ascending) {
                query.orderBy(builder.asc(root.get(orderColumn)));
            } else {
                query.orderBy(builder.desc(root.get(orderColumn)));
            }
        }
    }

}
