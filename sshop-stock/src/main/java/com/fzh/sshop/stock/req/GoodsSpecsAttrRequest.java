package com.fzh.sshop.stock.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsSpecsAttrRequest extends SuperRequest {

    @ApiModelProperty(value = "属性ID")
    private Integer attrId;
}
