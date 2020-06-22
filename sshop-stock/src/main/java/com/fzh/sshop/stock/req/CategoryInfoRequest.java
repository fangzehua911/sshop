package com.fzh.sshop.stock.req;
import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CategoryInfoRequest extends SuperRequest {

    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    @ApiModelProperty(value = "父ID")
    @NotBlank
    private Integer parentId;

    @ApiModelProperty(value = "等级")
    private Integer level;

    @ApiModelProperty(value = "分类名称")
    @NotBlank
    private String categoryName;

    @ApiModelProperty(value = "分类展示图")
    @NotBlank
    private String categoryImg;

    @ApiModelProperty(value = "状态T,F")
    @NotBlank
    private String flag;


}
