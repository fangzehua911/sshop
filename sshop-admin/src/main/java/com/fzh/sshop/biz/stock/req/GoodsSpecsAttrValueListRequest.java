package com.fzh.sshop.biz.stock.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class GoodsSpecsAttrValueListRequest extends SuperRequest {

    @ApiModelProperty(value = "属性ID")
    private Integer attrId;
    @Min(1)
    private Long pageNo;
    @Min(1)
    private Long PageSize;


}
