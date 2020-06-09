package com.fzh.sshop.gateway;

import com.fzh.sshop.gateway.config.jwt.TokenUtil;
import com.fzh.sshop.gateway.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/login")
    public String login(){
        User user = new User();
        user.setName("张三");
        user.setAge("1");
        user.setPasswd("123");
        return  TokenUtil.sign(user);
    }

    @GetMapping("/test/{token}")
    public String login(@PathVariable("token") String token){
        TokenUtil.verify(token);
        return "succ";
    }


}
