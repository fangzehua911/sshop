package com.fzh.sshop.app;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "代理管理类")
@RestController
@RequestMapping("/member")
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "ok-member";
    }

}
