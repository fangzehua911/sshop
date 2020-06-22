package com.fzh.sshop.stock.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BrandInfoRequest extends SuperRequest {


    private Integer brandId;

    @ApiModelProperty(value = "品牌名称")
    @NotBlank
    private String brandName;

    @NotBlank
    @ApiModelProperty(value = "品牌logo")
    private String brandLogo;

    @NotBlank
    @ApiModelProperty(value = "品牌描述")
    private String brandDesc;

    @NotBlank
    @ApiModelProperty(value = "状态T 可以 F 不可以")
    private String status;

}
