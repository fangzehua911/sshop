package com.fzh.sshop.web.stock.entity.net.request;

import io.swagger.annotations.ApiModelProperty;

public class SuperRequest {

    private Long pageNo;
    private Long pageSize;

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
