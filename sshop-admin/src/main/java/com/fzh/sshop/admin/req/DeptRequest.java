package com.fzh.sshop.admin.req;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class DeptRequest {

    @Min(0)
    private Integer deptId;

}
