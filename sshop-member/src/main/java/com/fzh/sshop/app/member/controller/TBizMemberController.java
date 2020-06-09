package com.fzh.sshop.app.member.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.app.member.service.impl.TBizMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/member")
public class TBizMemberController {

    @Autowired
    private TBizMemberServiceImpl tBizMemberService;

    @GetMapping("/list")
    public String getList(){

        return JSONObject.toJSONString(tBizMemberService.list());
    }

    @GetMapping("/create")
    public String getList2(){

        return JSONObject.toJSONString(tBizMemberService.create(null));
    }
}

