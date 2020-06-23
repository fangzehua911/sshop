package com.fzh.sshop.stock.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class GoodsSpecsAttrListRequest extends SuperRequest {

    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;
    @Min(1)
    private Long pageNo;
    @Min(1)
    private Long PageSize;
}
