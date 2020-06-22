package com.fzh.sshop.biz.stock.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class BrandListRequest extends SuperRequest {
    @Min(1)
    private Long pageNo;
    @Min(1)
    private Long PageSize;

    private String brandName;

    @ApiModelProperty(value = "状态T可用,F不可用")
    private String status;
}
