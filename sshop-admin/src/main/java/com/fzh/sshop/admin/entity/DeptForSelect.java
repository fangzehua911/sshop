package com.fzh.sshop.admin.entity;
import lombok.Data;

import java.util.List;

@Data
public class DeptForSelect {
    private String label;
    private Integer value;
    private List<DeptForSelect> children;
}
