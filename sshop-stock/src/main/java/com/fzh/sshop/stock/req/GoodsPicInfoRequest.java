package com.fzh.sshop.stock.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsPicInfoRequest extends SuperRequest {

    @ApiModelProperty(value = "商品编号")
    private String goodsNo;

    @ApiModelProperty(value = "图片地址")
    private String goodsImg;

    @ApiModelProperty(value = "百度图片标识")
    private String goodsImgCode;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}
