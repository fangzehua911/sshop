package com.fzh.sshop.admin.req.admin;

import com.fzh.sshop.request.SuperRequest;
import lombok.Data;
import javax.validation.constraints.Min;

@Data
public class UserListRequest extends SuperRequest {

    @Min(1)
    private Long pageNo;
    @Min(1)
    private Long PageSize;

}
