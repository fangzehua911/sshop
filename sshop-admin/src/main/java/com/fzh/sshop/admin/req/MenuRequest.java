package com.fzh.sshop.admin.req;

import com.fzh.sshop.request.SuperRequest;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class MenuRequest extends SuperRequest {

    @Min(0)
    private Integer menuId;

}
