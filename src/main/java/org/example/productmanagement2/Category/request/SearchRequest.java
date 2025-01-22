package org.example.productmanagement2.Category.request;

import org.example.productmanagement2.Category.model.Category;
import vn.saolasoft.base.service.filter.BaseFilter;
import vn.saolasoft.base.service.filter.PaginationInfo;

public class SearchRequest {
    private BaseFilter<Category, Long> baseFilter;
    private PaginationInfo paginationInfo;

    public BaseFilter<Category, Long> getBaseFilter() {
        return baseFilter;
    }

    public void setBaseFilter(BaseFilter<Category, Long> baseFilter) {
        this.baseFilter = baseFilter;
    }

    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }
}
