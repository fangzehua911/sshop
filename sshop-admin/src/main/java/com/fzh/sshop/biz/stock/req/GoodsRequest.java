package com.fzh.sshop.biz.stock.req;


import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsRequest extends SuperRequest {

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;
    @ApiModelProperty(value = "商品编号")
    private String goodsNo;

}
