package org.example.productmanagement2.Product.service.filter;

import jakarta.persistence.Query;
import org.springframework.stereotype.Component;
import vn.saolasoft.base.persistence.repository.OffsetBasedPageable;
import vn.saolasoft.base.service.filter.PaginationInfo;
import vn.saolasoft.base.service.filter.SortInfo;

import java.util.Set;

@Component
public class ProductPaging extends PaginationInfo {
    private static final long serialVersionUID = 1L;

    private int page;
    private int size;

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getSize() {
        return size;
    }

    public ProductPaging() {
        super();
    }

    public ProductPaging(int firstRow, int maxResults, String orderBy) {
        super(firstRow, maxResults, orderBy);
    }

    public ProductPaging(int firstRow, int maxResults, SortInfo... order) {
        super(firstRow, maxResults, order);
    }

    public Set<String> getSortableColumns() {
        return Set.of("product_name", "product_id");
    }

    public void applyPaging(Query jpaQuery) {
        if (page > -1 && size >-1) {
            jpaQuery.setFirstResult(page * size);
            jpaQuery.setMaxResults(size);
        }
    }

    @Override
    public OffsetBasedPageable toPageable(Set<String> sortableColumns) {
        return super.toPageable(sortableColumns);
    }
}
