package com.fzh.sshop.biz.stock.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsSpecsAttrRequest extends SuperRequest {

    @ApiModelProperty(value = "属性ID")
    private Integer attrId;
}