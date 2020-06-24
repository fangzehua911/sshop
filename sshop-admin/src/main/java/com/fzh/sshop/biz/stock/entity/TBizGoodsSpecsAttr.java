package com.fzh.sshop.biz.stock.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 属性表
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TBizGoodsSpecsAttr对象", description="属性表")
public class TBizGoodsSpecsAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "属性ID")
    @TableId(value = "attr_id", type = IdType.AUTO)
    private Integer attrId;

    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    @ApiModelProperty(value = "属性名称")
    private String attrName;

    @ApiModelProperty(value = "属性代码")
    private String attrCode;

    @ApiModelProperty(value = "属性状态 T,F")
    private String flag;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
