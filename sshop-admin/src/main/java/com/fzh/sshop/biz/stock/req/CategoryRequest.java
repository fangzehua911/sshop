package com.fzh.sshop.biz.stock.req;

import com.fzh.sshop.request.SuperRequest;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class CategoryRequest extends SuperRequest {

    @Min(1)
    private Integer categoryId;

}
