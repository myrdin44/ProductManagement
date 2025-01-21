package org.example.productmanagement2.product.request;

import org.example.productmanagement2.product.model.Product;
import vn.saolasoft.base.service.filter.BaseFilter;
import vn.saolasoft.base.service.filter.PaginationInfo;

public class SearchRequest {
    private BaseFilter<Product, Long> baseFilter;
    private PaginationInfo paginationInfo;

    public BaseFilter<Product, Long> getBaseFilter() {
        return baseFilter;
    }

    public void setBaseFilter(BaseFilter<Product, Long> baseFilter) {
        this.baseFilter = baseFilter;
    }

    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }
}
