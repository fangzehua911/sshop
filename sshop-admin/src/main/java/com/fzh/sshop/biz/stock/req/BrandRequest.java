package com.fzh.sshop.biz.stock.req;

import com.fzh.sshop.request.SuperRequest;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class BrandRequest extends SuperRequest {

    @Min(0)
    private Integer brandId;
}
