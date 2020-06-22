package com.fzh.sshop.biz.stock.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author fang
 * @since 2020-06-22
 */
@Data
public class TBizCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    @ApiModelProperty(value = "父ID")
    private Integer parentId;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "分类展示图")
    private String categoryImg;

    @ApiModelProperty(value = "状态T,F")
    private String flag;

    @ApiModelProperty(value = "等级")
    private Integer level;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private List<TBizCategory> Children;

}
